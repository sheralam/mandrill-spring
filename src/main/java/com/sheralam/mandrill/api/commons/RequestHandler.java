package com.sheralam.mandrill.api.commons;

import com.sheralam.mandrill.api.exceptions.MandrillCommunicationErrorResponse;
import com.sheralam.mandrill.api.exceptions.MandrillCommunicationException;
import lombok.Getter;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

@Slf4j
public abstract class RequestHandler<PayloadT extends AbstractPayload, ReturnT> implements OptionalBiFunction<PayloadT, ReturnT> {
    public static final String BaseUrl = "https://mandrillapp.com/api/1.0";
    private final static String NonNullSupplierMsg = "Rest Template Supplier MUST supply Non-Null RestTemplate";
    private final Supplier<RestTemplate> restTemplateSupplier;
    @Getter
    private final String endpoint;

    public RequestHandler(@NonNull String endpointSuffix, @NonNull Supplier<RestTemplate> restTemplateSupplier) {
        this.endpoint = BaseUrl + endpointSuffix;
        this.restTemplateSupplier = restTemplateSupplier;
    }

    protected abstract Class<ReturnT> getResponseClass();

    @Override
    @SneakyThrows
    public Optional<ReturnT> apply(PayloadT payloadT) {
        log.debug("Endpoint {}", endpoint);
        log.debug("Payload:: {}", payloadT.toString());
        try {
            var exchange = Objects.requireNonNull(restTemplateSupplier.get(), NonNullSupplierMsg)
                    .exchange(endpoint, HttpMethod.POST, new HttpEntity<>(payloadT), getResponseClass());
            if (HttpStatus.OK.equals(exchange.getStatusCode())) {
                return Optional.ofNullable(exchange.getBody());
            } else {
                log.error(" ERROR {}", exchange.getBody());
                throw new MandrillCommunicationException(new MandrillCommunicationErrorResponse(exchange.getStatusCode()));
            }
        } catch (HttpServerErrorException e) {
            throw new MandrillCommunicationException(new MandrillCommunicationErrorResponse(e.getStatusCode(), e.getClass().getSimpleName(), e.getResponseBodyAsString()));
        }
    }
}

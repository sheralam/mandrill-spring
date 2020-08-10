package com.sheralam.mandrill.api.commons;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

@Slf4j
public abstract class RequestHandler<PayloadT extends AbstractPayload, ReturnT> implements OptionalBiFunction<PayloadT, ReturnT> {
    private final static String NonNullSupplierMsg = "Rest Template Supplier MUST supply Non-Null RestTemplate";
    public static final String BaseUrl = "https://mandrillapp.com/api/1.0";
    private final Supplier<RestTemplate> restTemplateSupplier;
    @Getter
    private final String endpoint;

    public RequestHandler(@NonNull String endpointSuffix, @NonNull Supplier<RestTemplate> restTemplateSupplier) {
        this.endpoint = BaseUrl + endpointSuffix;
        this.restTemplateSupplier = restTemplateSupplier;
    }

    protected abstract Class<ReturnT> getResponseClass();

    @Override
    public Optional<ReturnT> apply(PayloadT payloadT) {
        try {
            log.debug("Endpoint {}", endpoint);
            log.debug("Payload:: {}", payloadT.toString());
            var exchange = Objects.requireNonNull(restTemplateSupplier.get(), NonNullSupplierMsg)
                    .exchange(endpoint, HttpMethod.POST, new HttpEntity<>(payloadT), getResponseClass());
            if (HttpStatus.OK.equals(exchange.getStatusCode())) {
                return Optional.ofNullable(exchange.getBody());
            } else {
                log.error(" ERROR {}", exchange.getBody());
                throw new RestClientException(exchange.getStatusCode().getReasonPhrase() + " with status code " + exchange.getStatusCode());
            }
        } catch (RestClientException rce) {
            log.warn("`{}` , posting to url={}", rce.getMessage(), endpoint);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return Optional.empty();
    }
}

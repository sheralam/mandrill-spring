package com.sheralam.mandrill.client;

import com.sheralam.mandrill.api.messages.MessagesCallsService;
import lombok.*;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import java.util.function.Supplier;

/**
 * MandrillClient for mandrill api integration.<br/>
 * It Depends on Spring Framework's {@link RestTemplate} <br/>
 * It provides similar functional interface as other language specific official mandrill integration library
 */
@Slf4j
@Value
public class MandrillClient {
    @Getter(AccessLevel.PACKAGE)
    String apiKey;

    @Getter(AccessLevel.PRIVATE)
    RestTemplate restTemplate;

    @Getter(AccessLevel.PRIVATE)
    Supplier<RestTemplate> restTemplateSupplier;

    @NonFinal
    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PRIVATE)
    MessagesCallsService messages;


    /**
     *
     * @param apiKey Mandrill Api Key
     * <br/> Creates {@link MandrillClient}
     */
    MandrillClient(@NonNull String apiKey) {
        this.apiKey = apiKey;
        restTemplate = null;
        restTemplateSupplier = new RestTemplateSupplier();
        init();
    }

    /**
     *
     * @param apiKey Mandrill Api Key
     * @param restTemplate spring boot {@link RestTemplate}
     * <br/> Creates {@link MandrillClient}
     */
    MandrillClient(@NonNull String apiKey, @NonNull RestTemplate restTemplate) {
        this.apiKey = apiKey;
        this.restTemplate = restTemplate;
        this.restTemplateSupplier = () -> this.restTemplate;
        init();
    }

    /**
     *
     * @param apiKey Mandrill Api Key
     * @param restTemplateSupplier Supplier of spring boot {@link RestTemplate}
     * <br/> Creates {@link MandrillClient}
     */
    MandrillClient(@NonNull String apiKey, @NonNull Supplier<RestTemplate> restTemplateSupplier) {
        this.apiKey = apiKey;
        this.restTemplate = null;
        this.restTemplateSupplier = restTemplateSupplier;
        init();
    }

    private void init() {
        setMessages(new MessagesCallsService(apiKey, restTemplateSupplier));
    }
}

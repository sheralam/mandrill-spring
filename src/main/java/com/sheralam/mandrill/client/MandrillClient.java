package com.sheralam.mandrill.client;

import com.sheralam.mandrill.api.messages.MessagesCallsService;
import lombok.*;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import java.util.function.Supplier;

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


    MandrillClient(@NonNull String apiKey) {
        this.apiKey = apiKey;
        restTemplate = null;
        restTemplateSupplier = new RestTemplateSupplier();
        init();
    }

    MandrillClient(@NonNull String apiKey, @NonNull RestTemplate restTemplate) {
        this.apiKey = apiKey;
        this.restTemplate = restTemplate;
        this.restTemplateSupplier = () -> this.restTemplate;
        init();
    }

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

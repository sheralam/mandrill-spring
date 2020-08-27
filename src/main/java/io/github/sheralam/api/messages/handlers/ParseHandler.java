package io.github.sheralam.api.messages.handlers;

import io.github.sheralam.api.commons.RequestHandler;
import io.github.sheralam.api.messages.model.request.ParsePayload;
import io.github.sheralam.api.messages.model.response.ParseResponse;
import lombok.NonNull;
import org.springframework.web.client.RestTemplate;

import java.util.function.Supplier;

public class ParseHandler extends RequestHandler<ParsePayload, ParseResponse> {
    private static final String endpointSuffix = "/messages/parse.json";

    public ParseHandler(@NonNull Supplier<RestTemplate> restTemplateSupplier) {
        super(endpointSuffix, restTemplateSupplier);
    }

    @Override
    protected Class<ParseResponse> getResponseClass() {
        return ParseResponse.class;
    }

}
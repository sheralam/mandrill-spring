package io.github.sheralam.api.messages.handlers;

import io.github.sheralam.api.commons.RequestHandler;
import io.github.sheralam.api.messages.model.request.ContentPayload;
import io.github.sheralam.api.messages.model.response.ContentResponse;
import lombok.NonNull;
import org.springframework.web.client.RestTemplate;

import java.util.function.Supplier;

public class ContentHandler extends RequestHandler<ContentPayload, ContentResponse> {
    private static final String endpointSuffix = "/messages/content.json";

    public ContentHandler(@NonNull Supplier<RestTemplate> restTemplateSupplier) {
        super(endpointSuffix, restTemplateSupplier);
    }

    @Override
    protected Class<ContentResponse> getResponseClass() {
        return ContentResponse.class;
    }

}
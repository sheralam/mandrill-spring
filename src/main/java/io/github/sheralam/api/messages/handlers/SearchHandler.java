package io.github.sheralam.api.messages.handlers;

import io.github.sheralam.api.commons.RequestHandler;
import io.github.sheralam.api.messages.model.request.SearchPayload;
import io.github.sheralam.api.messages.model.response.SearchResponse;
import lombok.NonNull;
import org.springframework.web.client.RestTemplate;

import java.util.function.Supplier;

public class SearchHandler extends RequestHandler<SearchPayload, SearchResponse[]> {
    private static final String endpointSuffix = "/messages/search.json";

    public SearchHandler(@NonNull Supplier<RestTemplate> restTemplateSupplier) {
        super(endpointSuffix, restTemplateSupplier);
    }

    @Override
    protected Class<SearchResponse[]> getResponseClass() {
        return SearchResponse[].class;
    }

}
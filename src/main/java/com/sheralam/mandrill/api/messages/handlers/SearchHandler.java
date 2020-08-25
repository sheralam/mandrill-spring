package com.sheralam.mandrill.api.messages.handlers;

import com.sheralam.mandrill.api.commons.RequestHandler;
import com.sheralam.mandrill.api.messages.model.request.SearchPayload;
import com.sheralam.mandrill.api.messages.model.response.SearchResponse;
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
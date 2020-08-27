package io.github.sheralam.api.messages.handlers;

import io.github.sheralam.api.commons.RequestHandler;
import io.github.sheralam.api.messages.model.request.SearchTimeSeriesPayload;
import io.github.sheralam.api.messages.model.response.SearchTimeSeriesResponse;
import lombok.NonNull;
import org.springframework.web.client.RestTemplate;

import java.util.function.Supplier;

public class SearchTimeSeriesHandler extends RequestHandler<SearchTimeSeriesPayload, SearchTimeSeriesResponse[]> {
    private static final String endpointSuffix = "/messages/search-time-series.json";

    public SearchTimeSeriesHandler(@NonNull Supplier<RestTemplate> restTemplateSupplier) {
        super(endpointSuffix, restTemplateSupplier);
    }

    @Override
    protected Class<SearchTimeSeriesResponse[]> getResponseClass() {
        return SearchTimeSeriesResponse[].class;
    }

}
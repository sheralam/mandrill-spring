package io.github.sheralam.api.messages.handlers;

import io.github.sheralam.api.commons.RequestHandler;
import io.github.sheralam.api.messages.model.request.ListScheduledPayload;
import io.github.sheralam.api.messages.model.response.ListScheduledResponse;
import lombok.NonNull;
import org.springframework.web.client.RestTemplate;

import java.util.function.Supplier;

public class ListScheduledHandler extends RequestHandler<ListScheduledPayload, ListScheduledResponse[]> {
    private static final String endpointSuffix = "/messages/list-scheduled.json";

    public ListScheduledHandler(@NonNull Supplier<RestTemplate> restTemplateSupplier) {
        super(endpointSuffix, restTemplateSupplier);
    }

    @Override
    protected Class<ListScheduledResponse[]> getResponseClass() {
        return ListScheduledResponse[].class;
    }

}
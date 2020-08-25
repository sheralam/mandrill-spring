package com.sheralam.mandrill.api.messages.handlers;

import com.sheralam.mandrill.api.commons.RequestHandler;
import com.sheralam.mandrill.api.messages.model.request.ListScheduledPayload;
import com.sheralam.mandrill.api.messages.model.request.MessagePayload;
import com.sheralam.mandrill.api.messages.model.response.ListScheduledResponse;
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
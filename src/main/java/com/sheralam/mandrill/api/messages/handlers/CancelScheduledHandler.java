package com.sheralam.mandrill.api.messages.handlers;

import com.sheralam.mandrill.api.commons.RequestHandler;
import com.sheralam.mandrill.api.messages.model.request.CancelScheduledPayload;
import com.sheralam.mandrill.api.messages.model.request.MessagePayload;
import com.sheralam.mandrill.api.messages.model.response.CancelScheduledResponse;
import lombok.NonNull;
import org.springframework.web.client.RestTemplate;

import java.util.function.Supplier;

public class CancelScheduledHandler extends RequestHandler<CancelScheduledPayload, CancelScheduledResponse> {
    private static final String endpointSuffix = "/messages/cancel-scheduled.json";

    public CancelScheduledHandler(@NonNull Supplier<RestTemplate> restTemplateSupplier) {
        super(endpointSuffix, restTemplateSupplier);
    }

    @Override
    protected Class<CancelScheduledResponse> getResponseClass() {
        return CancelScheduledResponse.class;
    }

}

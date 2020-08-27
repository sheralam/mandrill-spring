package io.github.sheralam.api.messages.handlers;

import io.github.sheralam.api.commons.RequestHandler;
import io.github.sheralam.api.messages.model.request.CancelScheduledPayload;
import io.github.sheralam.api.messages.model.response.CancelScheduledResponse;
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

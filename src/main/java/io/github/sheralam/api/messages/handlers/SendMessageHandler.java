package io.github.sheralam.api.messages.handlers;

import io.github.sheralam.api.commons.RequestHandler;
import io.github.sheralam.api.messages.model.request.MessagePayload;
import io.github.sheralam.api.messages.model.response.IndividualSuccessResponse;
import lombok.NonNull;
import org.springframework.web.client.RestTemplate;

import java.util.function.Supplier;

public class SendMessageHandler extends RequestHandler<MessagePayload, IndividualSuccessResponse[]> {
    private static final String endpointSuffix = "/messages/send.json";

    public SendMessageHandler(@NonNull Supplier<RestTemplate> restTemplateSupplier) {
        super(endpointSuffix, restTemplateSupplier);
    }

    @Override
    protected Class<IndividualSuccessResponse[]> getResponseClass() {
        return IndividualSuccessResponse[].class;
    }
}
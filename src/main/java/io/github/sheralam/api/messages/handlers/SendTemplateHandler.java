package io.github.sheralam.api.messages.handlers;

import io.github.sheralam.api.commons.RequestHandler;
import io.github.sheralam.api.messages.model.request.MessagePayload;
import io.github.sheralam.api.messages.model.response.IndividualSuccessResponse;
import lombok.NonNull;
import org.springframework.web.client.RestTemplate;

import java.util.function.Supplier;

public class SendTemplateHandler extends RequestHandler<MessagePayload, IndividualSuccessResponse[]> {
    private static final String endpointSuffix = "/messages/send-template.json";

    public SendTemplateHandler(@NonNull Supplier<RestTemplate> restTemplateSupplier) {
        super(endpointSuffix, restTemplateSupplier);
    }

    @Override
    protected Class<IndividualSuccessResponse[]> getResponseClass() {
        return IndividualSuccessResponse[].class;
    }

}
package com.sheralam.mandrill.api.messages.handlers;

import com.sheralam.mandrill.api.commons.RequestHandler;
import com.sheralam.mandrill.api.messages.model.request.MessagePayload;
import com.sheralam.mandrill.api.messages.model.response.IndividualSuccessResponse;
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
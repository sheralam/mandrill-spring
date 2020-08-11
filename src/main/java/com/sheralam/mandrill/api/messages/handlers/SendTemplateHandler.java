package com.sheralam.mandrill.api.messages.handlers;

import com.sheralam.mandrill.api.commons.RequestHandler;
import com.sheralam.mandrill.api.messages.model.request.MessagePayload;
import com.sheralam.mandrill.api.messages.model.response.IndividualSuccessResponse;
import lombok.NonNull;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
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
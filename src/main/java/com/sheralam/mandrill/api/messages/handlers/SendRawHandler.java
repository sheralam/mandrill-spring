package com.sheralam.mandrill.api.messages.handlers;

import com.sheralam.mandrill.api.commons.RequestHandler;
import com.sheralam.mandrill.api.messages.model.request.MessagePayload;
import com.sheralam.mandrill.api.messages.model.request.SendRawPayload;
import com.sheralam.mandrill.api.messages.model.response.IndividualSuccessResponse;
import com.sheralam.mandrill.api.messages.model.response.SendRawResponse;
import lombok.NonNull;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.function.Supplier;

public class SendRawHandler extends RequestHandler<SendRawPayload, SendRawResponse[]> {
    private static final String endpointSuffix = "/messages/send-raw.json";


    public SendRawHandler(@NonNull Supplier<RestTemplate> restTemplateSupplier) {
        super(endpointSuffix, restTemplateSupplier);
    }
    @Override
    protected Class<SendRawResponse[]> getResponseClass() {
        return SendRawResponse[].class;
    }

}
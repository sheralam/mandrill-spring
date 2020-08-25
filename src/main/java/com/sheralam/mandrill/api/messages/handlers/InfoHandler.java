package com.sheralam.mandrill.api.messages.handlers;

import com.sheralam.mandrill.api.commons.RequestHandler;
import com.sheralam.mandrill.api.messages.model.request.InfoPayload;
import com.sheralam.mandrill.api.messages.model.request.MessagePayload;
import com.sheralam.mandrill.api.messages.model.response.InfoResponse;
import lombok.NonNull;
import org.springframework.web.client.RestTemplate;

import java.util.function.Supplier;

public class InfoHandler extends RequestHandler<InfoPayload, InfoResponse> {
    private static final String endpointSuffix = "/messages/info.json";


    public InfoHandler(@NonNull Supplier<RestTemplate> restTemplateSupplier) {
        super(endpointSuffix, restTemplateSupplier);
    }
    @Override
    protected Class<InfoResponse> getResponseClass() {
        return InfoResponse.class;
    }

}
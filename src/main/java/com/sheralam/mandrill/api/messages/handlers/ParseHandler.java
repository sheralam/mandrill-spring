package com.sheralam.mandrill.api.messages.handlers;

import com.sheralam.mandrill.api.commons.RequestHandler;
import com.sheralam.mandrill.api.messages.model.request.MessagePayload;
import com.sheralam.mandrill.api.messages.model.request.ParsePayload;
import com.sheralam.mandrill.api.messages.model.response.IndividualSuccessResponse;
import com.sheralam.mandrill.api.messages.model.response.ParseResponse;
import lombok.NonNull;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.function.Supplier;

public class ParseHandler extends RequestHandler<ParsePayload, ParseResponse> {
    private static final String endpointSuffix = "/messages/parse.json";


    public ParseHandler(@NonNull Supplier<RestTemplate> restTemplateSupplier) {
        super(endpointSuffix, restTemplateSupplier);
    }
    @Override
    protected Class<ParseResponse> getResponseClass() {
        return ParseResponse.class;
    }

}
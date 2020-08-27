package io.github.sheralam.api.messages.handlers;

import io.github.sheralam.api.commons.RequestHandler;
import io.github.sheralam.api.messages.model.request.SendRawPayload;
import io.github.sheralam.api.messages.model.response.SendRawResponse;
import lombok.NonNull;
import org.springframework.web.client.RestTemplate;

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
package com.sheralam.mandrill.api.messages;

import com.sheralam.mandrill.api.messages.model.request.Message;
import com.sheralam.mandrill.api.messages.model.response.IndividualSuccessResponse;
import com.sheralam.mandrill.client.MandrillClient;
import com.sheralam.mandrill.client.MandrillClientFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class MessagesCallsServiceTest {
    @Test
    void send() {
        MandrillClient clientForApiKey = MandrillClientFactory.getClientForApiKey("invalid_api");
        Assertions.assertNotNull(clientForApiKey);
        Assertions.assertNotNull(clientForApiKey.getMessages());
        Optional<IndividualSuccessResponse[]> responses = clientForApiKey.getMessages().send(new Message());
        assertFalse(responses.isPresent());
    }
}
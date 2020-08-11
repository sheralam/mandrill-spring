package com.sheralam.mandrill.api.messages;

import com.sheralam.mandrill.api.exceptions.MandrillCommunicationException;
import com.sheralam.mandrill.api.messages.model.request.Message;
import com.sheralam.mandrill.client.MandrillClient;
import com.sheralam.mandrill.client.MandrillClientFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MessagesCallsServiceTest {
    @Test
    void send() {
        MandrillClient clientForApiKey = MandrillClientFactory.getClientForApiKey("invalid_api");
        Assertions.assertNotNull(clientForApiKey);
        Assertions.assertNotNull(clientForApiKey.getMessages());
        assertThrows(MandrillCommunicationException.class, () -> MandrillClientFactory.getClientForApiKey("invalid_api", () -> null).getMessages().send(new Message()));
    }
}
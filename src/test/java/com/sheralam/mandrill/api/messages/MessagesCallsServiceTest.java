package com.sheralam.mandrill.api.messages;

import com.sheralam.mandrill.api.exceptions.MandrillCommunicationException;
import com.sheralam.mandrill.api.messages.model.request.Message;
import com.sheralam.mandrill.api.messages.model.request.TemplateContent;
import com.sheralam.mandrill.client.MandrillClient;
import com.sheralam.mandrill.client.MandrillClientFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MessagesCallsServiceTest {
    private final String invalidApi = "invalid_api";
    @Test
    void send() {
        MandrillClient clientForApiKey = MandrillClientFactory.getClientForApiKey(invalidApi);
        Assertions.assertNotNull(clientForApiKey);
        Assertions.assertNotNull(clientForApiKey.getMessages());
        assertThrows(MandrillCommunicationException.class, () -> MandrillClientFactory.getClientForApiKey("invalid_api", () -> null).getMessages().send(new Message()));
    }

    @Test
    void sendTemplate() {
        MandrillClient clientForApiKey = MandrillClientFactory.getClientForApiKey(invalidApi);
        Assertions.assertNotNull(clientForApiKey);
        Assertions.assertNotNull(clientForApiKey.getMessages());
        assertThrows(MandrillCommunicationException.class, () -> MandrillClientFactory.getClientForApiKey("invalid_api", () -> null).getMessages().sendTemplate("template_name", new TemplateContent("content_name", "content"),new Message()));
    }

    @Test
    void testSend() {
    }

    @Test
    void testSendTemplate() {
    }

    @Test
    void content() {
    }

    @Test
    void cancelScheduled() {
    }

    @Test
    void info() {
    }

    @Test
    void listScheduled() {
    }

    @Test
    void parse() {
    }

    @Test
    void reschedule() {
    }

    @Test
    void search() {
    }

    @Test
    void searchTimeSeries() {
    }

    @Test
    void sendRaw() {
    }
}
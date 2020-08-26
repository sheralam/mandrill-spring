package com.sheralam.mandrill.api.messages;

import com.sheralam.mandrill.api.exceptions.MandrillCommunicationException;
import com.sheralam.mandrill.api.messages.model.request.*;
import com.sheralam.mandrill.client.MandrillClientFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MessagesCallsServiceTest {
    private final String invalidApi = "invalid_api";
    private MessagesCallsService messages;

    @BeforeEach
    void init() {
        messages = MandrillClientFactory.getClientForApiKey("invalid_api").getMessages();
    }


    @Test
    void send() {
        assertThrows(MandrillCommunicationException.class, () -> messages.send(new Message()));
    }

    @Test
    void sendTemplate() {
        assertThrows(MandrillCommunicationException.class, () -> messages.sendTemplate("template_name", new TemplateContent("content_name", "content"), new Message()));
    }


    @Test
    void content() {
        assertThrows(MandrillCommunicationException.class, () -> messages.content("invalid_id"));
    }

    @Test
    void cancelScheduled() {
        assertThrows(MandrillCommunicationException.class, () -> messages.cancelScheduled("invalid_id"));
    }

    @Test
    void info() {
        assertThrows(MandrillCommunicationException.class, () -> messages.info("invalid_id"));
    }

    @Test
    void listScheduled() {
        assertThrows(MandrillCommunicationException.class, () -> messages.listScheduled("abc@example.bd"));
    }

    @Test
    void parse() {
        assertThrows(MandrillCommunicationException.class, () -> messages.parse("rawMessage"));
    }

    @Test
    void reschedule() {
        assertThrows(MandrillCommunicationException.class, () -> messages.reschedule("invalid_id", "invalid_date"));
    }

    @Test
    void search() {
        assertThrows(MandrillCommunicationException.class, () -> messages.search(new Search()));
    }

    @Test
    void searchTimeSeries() {
        assertThrows(MandrillCommunicationException.class, () -> messages.searchTimeSeries(new SearchTimeSeries()));
    }

    @Test
    void sendRaw() {
        assertThrows(MandrillCommunicationException.class, () -> messages.sendRaw(new SendRaw()));
    }
}
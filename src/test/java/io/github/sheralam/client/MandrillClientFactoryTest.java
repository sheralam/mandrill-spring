package io.github.sheralam.client;

import io.github.sheralam.api.messages.model.request.Message;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class MandrillClientFactoryTest {
    String testApiKey = "my_api_key";

    void validateClient(MandrillClient mandrillClient) {
        assertNotNull(mandrillClient);
        assertEquals(testApiKey, mandrillClient.getApiKey());
    }

    @Test
    void getClientForApiKey() {
        validateClient(MandrillClientFactory.getClientForApiKey(testApiKey));
    }

    @Test
    void testGetClientForApiKeyTemplateProvided() {
        validateClient(MandrillClientFactory.getClientForApiKey(testApiKey, mock(RestTemplate.class)));
    }

    @Test
    void testGetClientForApiKeyTemplateSupplierProvided() {
        validateClient(MandrillClientFactory.getClientForApiKey(testApiKey, () -> mock(RestTemplate.class)));
    }

    @Test
    void testGetClientForApiKeyTemplateSupplierProvidesNull() {
        assertThrows(NullPointerException.class, () -> MandrillClientFactory.getClientForApiKey(testApiKey, () -> null).getMessages().send(new Message()));
    }
}
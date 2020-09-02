package io.github.sheralam.client;

import lombok.NonNull;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

/**
 * MandrillClientFactory Provides various different ways of creating  {@link MandrillClient}.
 * ApiKey is the Must,   however, should we need to override default {@link RestTemplate} provided by the {@link RestTemplateSupplier},
 * We can provide either an Object of {@link RestTemplate} or {@link Supplier} of {@link RestTemplate}
 */
public class MandrillClientFactory {
    final static private Map<String, MandrillClient> clientsMap = new ConcurrentHashMap<>();

    /**
     *
     * @param apiKey mandrill api key
     * @return {@link MandrillClient} with default setup
     */
    public static synchronized MandrillClient getClientForApiKey(@NonNull String apiKey) {
        return clientsMap.computeIfAbsent(apiKey, MandrillClient::new);
    }

    /**
     *
     * @param apiKey mandrill api key
     * @param restTemplateSupplier supplies RestTemplate that overrides default
     * @return {@link MandrillClient} with provided RestTemplate
     */
    public static synchronized MandrillClient getClientForApiKey(@NonNull String apiKey, @NonNull Supplier<RestTemplate> restTemplateSupplier) {
        return clientsMap.computeIfAbsent(apiKey, key -> new MandrillClient(key, restTemplateSupplier));
    }


    /**
     *
     * @param apiKey mandrill api key
     * @param restTemplate  that overrides default
     * @return {@link MandrillClient} with provided RestTemplate
     */
    public static synchronized MandrillClient getClientForApiKey(@NonNull String apiKey, @NonNull RestTemplate restTemplate) {
        return clientsMap.computeIfAbsent(apiKey, key -> new MandrillClient(key, restTemplate));
    }
}

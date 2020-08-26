package com.sheralam.mandrill.client;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.function.Supplier;

/**
 * Default {@link RestTemplate} supplier class
 */
@Slf4j
@Value
public class RestTemplateSupplier implements Supplier<RestTemplate> {
    /**
     *
     * @return {@link RestTemplate}
     */
    @Override
    public RestTemplate get() {
        log.debug("Creating  mandrill RestTemplate");
        var requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(3000);
        requestFactory.setReadTimeout(3000);
        var jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        jackson2HttpMessageConverter.getObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        var restTemplate = new RestTemplate(requestFactory);
        restTemplate.setMessageConverters(List.of(jackson2HttpMessageConverter, new StringHttpMessageConverter()));
        return restTemplate;
    }
}

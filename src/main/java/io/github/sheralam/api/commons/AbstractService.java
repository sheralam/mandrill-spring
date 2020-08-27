package io.github.sheralam.api.commons;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.function.Supplier;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@RequiredArgsConstructor
public abstract class AbstractService implements Serializable {
    private static final long serialVersionUID = 6288607929592787988L;
    @Getter(AccessLevel.PROTECTED)
    private final String apiKey;

    protected abstract void init(Supplier<RestTemplate> restTemplateSupplier);
}

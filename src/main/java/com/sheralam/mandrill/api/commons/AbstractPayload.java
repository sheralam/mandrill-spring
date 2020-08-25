package com.sheralam.mandrill.api.commons;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.SneakyThrows;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractPayload implements Serializable {
    private static final long serialVersionUID = -1329073643934511423L;
    protected final String key;

    protected AbstractPayload(String key) {
        this.key = key;
    }

    @SneakyThrows
    protected AbstractPayload() {
        this("");
        throw new Exception("Key must be provided.");

    }
}

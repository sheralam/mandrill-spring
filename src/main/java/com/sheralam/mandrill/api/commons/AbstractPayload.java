package com.sheralam.mandrill.api.commons;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractPayload implements Serializable {
    protected final String key;

    protected AbstractPayload(String key) {
        this.key = key;
    }
    protected AbstractPayload() {
        this("");
    }
}

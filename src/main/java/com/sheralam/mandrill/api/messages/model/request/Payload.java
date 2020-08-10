package com.sheralam.mandrill.api.messages.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sheralam.mandrill.api.commons.AbstractPayload;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class Payload extends AbstractPayload implements Serializable {
    protected final String sendAt = "2000-10-01 01:01:01"; // set previous date to send immediately. otherwise additional cost will be charged
    protected final boolean async = true;
    protected String ipPool = "";

    protected Payload(String key) {
        super(key);
    }

    @SneakyThrows
    protected Payload() {
        super();
        throw new Exception("Key must be provided.");
    }
}

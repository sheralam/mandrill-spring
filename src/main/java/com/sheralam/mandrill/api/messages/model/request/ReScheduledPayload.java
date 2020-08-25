package com.sheralam.mandrill.api.messages.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sheralam.mandrill.api.commons.AbstractPayload;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;


@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Slf4j
public class ReScheduledPayload extends AbstractPayload {
    private static final long serialVersionUID = 821962812353991993L;
    private String id;
    public String sendAt;

    public ReScheduledPayload(String key){
        super(key);
    }

    public ReScheduledPayload(String key, String id, String sendAt) {
        super(key);
        this.id = id;
        this.sendAt = sendAt;
    }
}
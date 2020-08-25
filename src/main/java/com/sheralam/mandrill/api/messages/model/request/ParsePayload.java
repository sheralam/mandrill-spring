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
public class ParsePayload extends AbstractPayload {
    private static final long serialVersionUID = -895933490196293098L;

    private String rawMessage;

    public ParsePayload(String key) {
        super(key);
    }

    public ParsePayload(String key, String rawMessage) {
        super(key);
        this.rawMessage = rawMessage;
    }
}
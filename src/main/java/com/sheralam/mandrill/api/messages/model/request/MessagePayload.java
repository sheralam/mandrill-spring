package com.sheralam.mandrill.api.messages.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Slf4j
public class MessagePayload extends Payload implements Serializable {

    private final static long serialVersionUID = -548626036118002490L;
    Message message;

    public MessagePayload(String key, Message message) {
        super(key);
        this.message = message;
        log.debug("MessagePayload Created with key {}", key);
    }

    @Override
    public String toString() {
        return "MessagePayload{" +
                "sendAt='" + sendAt + '\'' +
                ", async=" + async +
                ", key='" + key + '\'' +
                ", ipPool='" + ipPool + '\'' +
                '}';
    }
}

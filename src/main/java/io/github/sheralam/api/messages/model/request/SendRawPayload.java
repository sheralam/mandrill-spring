package io.github.sheralam.api.messages.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.sheralam.api.commons.AbstractPayload;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Slf4j
public class SendRawPayload extends AbstractPayload {
    private static final long serialVersionUID = -3852172064563582399L;
    public String rawMessage;
    public String fromEmail;
    public String fromName;
    public List<String> to = new ArrayList<>();
    public boolean async;
    public String ipPool;
    public String sendAt;
    public String returnPathDomain;

    public SendRawPayload(String key) {
        super(key);
    }

    public SendRawPayload(String key, SendRaw sendRaw) {
        super(key);
        rawMessage = sendRaw.getRawMessage();
        fromEmail = sendRaw.getFromEmail();
        fromName = sendRaw.getFromName();
        to = sendRaw.getTo();
        async = sendRaw.isAsync();
        ipPool = sendRaw.getIpPool();
        sendAt = sendRaw.getSendAt();
        returnPathDomain = sendRaw.getReturnPathDomain();
    }
}
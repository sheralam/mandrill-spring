package io.github.sheralam.api.messages.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.sheralam.api.commons.AbstractPayload;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractMessageAndTemplatePayload extends AbstractPayload implements Serializable {
    private static final long serialVersionUID = -154025600166807479L;
    protected final String sendAt = "2000-10-01 01:01:01"; // set previous date to send immediately. otherwise additional cost will be charged
    protected final boolean async = true;
    protected String ipPool = "";

    protected AbstractMessageAndTemplatePayload(String key) {
        super(key);
    }

    protected AbstractMessageAndTemplatePayload() {
        super();
    }
}

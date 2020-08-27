package io.github.sheralam.api.messages.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.sheralam.api.commons.AbstractPayload;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;


@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Slf4j
public class ListScheduledPayload extends AbstractPayload {
    private static final long serialVersionUID = -7658124329185027241L;
    private String to;

    public ListScheduledPayload(String key) {
        super(key);
    }

    public ListScheduledPayload(String key, String to) {
        super(key);
        this.to = to;
    }
}
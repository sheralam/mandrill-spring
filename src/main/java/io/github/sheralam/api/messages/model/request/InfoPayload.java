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
public class InfoPayload extends AbstractPayload {
    private static final long serialVersionUID = 6477194538028113616L;
    public String id;

    public InfoPayload(String key) {
        super(key);
    }

    public InfoPayload(String key, String id) {
        super(key);
        this.id = id;
    }
}
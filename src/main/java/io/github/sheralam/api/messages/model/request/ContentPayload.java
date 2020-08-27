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
public class ContentPayload extends AbstractPayload {
    private static final long serialVersionUID = -6193722556434745956L;
    public String id;

    public ContentPayload(String key){
        super(key);
    }

    public ContentPayload(String key, String id) {
        super(key);
        this.id = id;
    }
}
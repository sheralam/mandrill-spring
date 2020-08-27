package io.github.sheralam.api.messages.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class TemplatePayload extends MessagePayload implements Serializable {

    private final static long serialVersionUID = 629126036398002490L;
    private String templateName;
    private TemplateContent templateContent;


    public TemplatePayload(String key, String templateName, TemplateContent templateContent, Message message) {
        super(key, message);
        this.templateName = templateName;
        this.templateContent = templateContent;
    }
}

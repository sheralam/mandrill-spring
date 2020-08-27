package io.github.sheralam.api.messages.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.sheralam.api.commons.AbstractResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ParseResponse extends AbstractResponse {

    private static final long serialVersionUID = 5212944055454973278L;
    public String subject;
    public String fromEmail;
    public String fromName;
    public List<To> to = new ArrayList<>();
    public Headers headers;
    public String text;
    public String html;
    public List<Attachment> attachments = new ArrayList<>();
    public List<Image> images = new ArrayList<>();
}

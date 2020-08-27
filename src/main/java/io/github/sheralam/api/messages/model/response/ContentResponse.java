package io.github.sheralam.api.messages.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.sheralam.api.commons.AbstractResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ContentResponse extends AbstractResponse {

    private static final long serialVersionUID = -7306508969381676378L;
    public long ts;
    @JsonProperty("_id")
    public String id;
    public String fromEmail;
    public String fromName;
    public String subject;
    public To to;
    public List<String> tags = new ArrayList<>();
    public Headers headers;
    public String text;
    public String html;
    public List<Attachment> attachments = new ArrayList<>();
}

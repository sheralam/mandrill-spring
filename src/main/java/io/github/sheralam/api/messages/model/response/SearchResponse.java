package io.github.sheralam.api.messages.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.sheralam.api.commons.AbstractResponse;
import io.github.sheralam.api.messages.model.request.Metadata;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class SearchResponse extends AbstractResponse {
    private static final long serialVersionUID = -8026135863588687908L;
    public long ts;
    @JsonProperty("_id")
    public String id;
    public String sender;
    public String template;
    public String subject;
    public String email;
    public List<String> tags = null;
    public long opens;
    public List<OpensDetail> opensDetail = null;
    public long clicks;
    public List<ClicksDetail> clicksDetail = null;
    public String state;
    public Metadata metadata;
}

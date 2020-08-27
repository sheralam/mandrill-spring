package io.github.sheralam.api.messages.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class SmtpEvent implements Serializable {

    private final static long serialVersionUID = -8484478869886603546L;
    @JsonProperty("ts")
    public long ts;
    @JsonProperty("type")
    public String type;
    @JsonProperty("diag")
    public String diag;

}

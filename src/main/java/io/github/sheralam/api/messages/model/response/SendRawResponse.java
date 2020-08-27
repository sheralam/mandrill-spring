package io.github.sheralam.api.messages.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.sheralam.api.commons.AbstractResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class SendRawResponse extends AbstractResponse {

    private static final long serialVersionUID = -7480294071094952741L;
    public String email;
    public String status;
    public String rejectReason;
    @JsonProperty("_id")
    public String id;
}

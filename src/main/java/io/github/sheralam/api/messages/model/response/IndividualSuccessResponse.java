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
public class IndividualSuccessResponse extends AbstractResponse {
    private static final long serialVersionUID = -4360813971391980885L;
    private String email;
    private String status;
    @JsonProperty("reject_reason")
    private String rejectReason;
    @JsonProperty("_id")
    private String id;
}
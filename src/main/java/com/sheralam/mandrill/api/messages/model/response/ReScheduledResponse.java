package com.sheralam.mandrill.api.messages.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sheralam.mandrill.api.commons.AbstractResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ReScheduledResponse extends AbstractResponse {

    private static final long serialVersionUID = -6096586270213066622L;
    @JsonProperty("_id")
    public String id;
    public String createdAt;
    public String sendAt;
    public String fromEmail;
    public String to;
    public String subject;
}

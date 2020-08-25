package com.sheralam.mandrill.api.messages.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Headers implements Serializable {

    private static final long serialVersionUID = -8952856890959124246L;
    @JsonProperty("Reply-To")
    public String replyTo;

}

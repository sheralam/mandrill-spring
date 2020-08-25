package com.sheralam.mandrill.api.messages.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class OpensDetail implements Serializable {

    private static final long serialVersionUID = 5049689399869004307L;
    public long ts;
    public String ip;
    public String location;
    public String ua;

}

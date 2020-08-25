package com.sheralam.mandrill.api.messages.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ClicksDetail implements Serializable {

    private static final long serialVersionUID = 1790718671961085233L;
    public long ts;
    public String url;
    public String ip;
    public String location;
    public String ua;

}

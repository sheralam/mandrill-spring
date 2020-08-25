package com.sheralam.mandrill.api.messages.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sheralam.mandrill.api.commons.AbstractPayload;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Slf4j
public class SendRaw implements Serializable {
    private static final long serialVersionUID = 182121211802917378L;
    public String rawMessage;
    public String fromEmail;
    public String fromName;
    public List<String> to = new ArrayList<>();
    public boolean async;
    public String ipPool;
    public String sendAt;
    public String returnPathDomain;
}
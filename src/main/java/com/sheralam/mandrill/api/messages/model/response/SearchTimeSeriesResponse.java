package com.sheralam.mandrill.api.messages.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sheralam.mandrill.api.commons.AbstractResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class SearchTimeSeriesResponse extends AbstractResponse {

    private static final long serialVersionUID = -2619967077318693138L;
    public String time;
    public long sent;
    public long hardBounces;
    public long softBounces;
    public long rejects;
    public long complaints;
    public long unsubs;
    public long opens;
    public long uniqueOpens;
    public long clicks;
    public long uniqueClicks;
}

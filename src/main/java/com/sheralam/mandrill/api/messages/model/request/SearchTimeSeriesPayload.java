package com.sheralam.mandrill.api.messages.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sheralam.mandrill.api.commons.AbstractPayload;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Slf4j
public class SearchTimeSeriesPayload extends AbstractPayload {

    private static final long serialVersionUID = -846900767764522692L;
    public String query;
    public String dateFrom;
    public String dateTo;
    public List<String> tags = new ArrayList<>();
    public List<String> senders = new ArrayList<>();

    public  SearchTimeSeriesPayload(String key){
        super(key);
    }

}
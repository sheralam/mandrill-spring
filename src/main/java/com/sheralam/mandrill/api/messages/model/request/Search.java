package com.sheralam.mandrill.api.messages.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Slf4j
public class Search implements Serializable {
    private static final long serialVersionUID = -5712387753323409835L;
    public String query;
    public String dateFrom;
    public String dateTo;
    public List<String> tags = new ArrayList<>();
    public List<String> senders = new ArrayList<>();
    public List<String> apiKeys = new ArrayList<>();
    public long limit;
}

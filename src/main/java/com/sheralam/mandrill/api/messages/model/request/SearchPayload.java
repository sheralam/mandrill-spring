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


@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Slf4j
public class SearchPayload extends AbstractPayload implements Serializable {
    private static final long serialVersionUID = 6583242138275632064L;
    public String query;
    public String dateFrom;
    public String dateTo;
    public List<String> tags = new ArrayList<>();
    public List<String> senders = new ArrayList<>();
    public List<String> apiKeys = new ArrayList<>();
    public long limit;

    public SearchPayload(String key) {
        super(key);
    }

    public SearchPayload(String key, Search search) {
        super(key);
        query = search.getQuery();
        dateFrom = search.getDateFrom();
        dateTo = search.getDateTo();
        tags = search.getTags();
        senders = search.getSenders();
        apiKeys = search.getApiKeys();
        limit = search.getLimit();
    }
}

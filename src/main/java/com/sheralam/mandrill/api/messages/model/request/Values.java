package com.sheralam.mandrill.api.messages.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
public class Values implements Serializable {

    private final static long serialVersionUID = 1241159118933692640L;
    private long userId;

    public Values(long userId) {
        super();
        this.userId = userId;
    }

}

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
public class Var implements Serializable {

    private final static long serialVersionUID = -4808240665166840204L;
    private String name;
    private String content;

    public Var(String name, String content) {
        super();
        this.name = name;
        this.content = content;
    }

}

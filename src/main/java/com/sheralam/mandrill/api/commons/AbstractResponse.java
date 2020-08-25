package com.sheralam.mandrill.api.commons;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public abstract class AbstractResponse implements Serializable {
    private static final long serialVersionUID = -923382378305648567L;
}

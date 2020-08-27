package io.github.sheralam.api.messages.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Metadata implements Serializable {

    private static final long serialVersionUID = 7538943026381600810L;
    public String userId;
    public String website;

}

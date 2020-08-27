package io.github.sheralam.api.messages.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Attachment implements Serializable {

    private static final long serialVersionUID = -7420734292217388745L;
    public String name;
    public String type;
    public String content;

}

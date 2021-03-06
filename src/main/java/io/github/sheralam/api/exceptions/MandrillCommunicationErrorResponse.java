package io.github.sheralam.api.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MandrillCommunicationErrorResponse implements Serializable {
    private static final long serialVersionUID = 8163077229023118863L;
    private HttpStatus statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
    private String name = HttpStatus.INTERNAL_SERVER_ERROR.toString();
    private String message = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();

    public MandrillCommunicationErrorResponse(HttpStatus statusCode) {
        this.statusCode = statusCode;
        name = statusCode.toString();
        message = statusCode.getReasonPhrase();
    }

    @Override
    public String toString() {
        return "{" +
                "statusCode=" + statusCode.value() +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

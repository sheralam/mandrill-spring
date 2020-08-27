package io.github.sheralam.api.exceptions;

import lombok.Getter;
import org.springframework.web.client.RestClientException;

public class MandrillCommunicationException extends RestClientException {
    private static final long serialVersionUID = 212391650842257159L;
    @Getter
    MandrillCommunicationErrorResponse errorResponse = new MandrillCommunicationErrorResponse();

    public MandrillCommunicationException(String msg) {
        super(msg);
        this.errorResponse.setMessage(msg);
    }

    public MandrillCommunicationException(String msg, Throwable ex) {
        super(msg, ex);
        this.errorResponse.setName(ex.getClass().getName());
        this.errorResponse.setMessage(msg);
    }

    public MandrillCommunicationException(MandrillCommunicationErrorResponse errorResponse) {
        super(errorResponse.getMessage());
        this.errorResponse = errorResponse;
    }


    @Override
    public String getMessage() {
        return errorResponse.toString();
    }
}

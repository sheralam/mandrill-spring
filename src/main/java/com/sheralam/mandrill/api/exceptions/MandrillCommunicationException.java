package com.sheralam.mandrill.api.exceptions;

import lombok.Getter;
import org.springframework.web.client.RestClientException;

public class MandrillCommunicationException extends RestClientException {
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

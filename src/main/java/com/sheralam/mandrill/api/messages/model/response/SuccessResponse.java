package com.sheralam.mandrill.api.messages.model.response;

import lombok.Data;

import java.util.List;

@Data
public class SuccessResponse {
    private List<IndividualSuccessResponse> individualSuccessResponseList;
}


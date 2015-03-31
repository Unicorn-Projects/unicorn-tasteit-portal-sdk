package io.tasteit.rest.service.model.exception;

import io.tasteit.rest.service.model.response.ErrorResponse;

public class InvalidRequestException extends BadRequestException {

    private static final long serialVersionUID = -1L;
    
    public InvalidRequestException(String errorCode, String errorDesc) {
        super(errorCode, errorDesc);
    }
    
    public InvalidRequestException(ErrorResponse error) {
        super(error);
    }
}
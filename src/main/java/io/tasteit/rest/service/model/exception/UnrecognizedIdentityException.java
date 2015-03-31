package io.tasteit.rest.service.model.exception;

import io.tasteit.rest.service.model.response.ErrorResponse;

public class UnrecognizedIdentityException extends UnauthorizedRequestException {

    private static final long serialVersionUID = -1L;
    
    public UnrecognizedIdentityException(String errorCode, String errorDesc) {
        super(errorCode, errorDesc);
    }
    
    public UnrecognizedIdentityException(ErrorResponse error) {
        super(error);
    }
}
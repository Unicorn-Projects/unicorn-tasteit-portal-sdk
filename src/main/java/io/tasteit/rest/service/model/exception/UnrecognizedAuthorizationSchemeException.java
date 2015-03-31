package io.tasteit.rest.service.model.exception;

import io.tasteit.rest.service.model.response.ErrorResponse;

public class UnrecognizedAuthorizationSchemeException extends UnauthorizedRequestException {

    private static final long serialVersionUID = -1L;
    
    public UnrecognizedAuthorizationSchemeException(String errorCode, String errorDesc) {
        super(errorCode, errorDesc);
    }
    
    public UnrecognizedAuthorizationSchemeException(ErrorResponse error) {
        super(error);
    }
}
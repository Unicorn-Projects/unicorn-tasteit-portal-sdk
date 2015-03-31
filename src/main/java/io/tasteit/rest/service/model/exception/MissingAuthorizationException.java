package io.tasteit.rest.service.model.exception;

import io.tasteit.rest.service.model.response.ErrorResponse;

public class MissingAuthorizationException extends UnauthorizedRequestException {

    private static final long serialVersionUID = -1L;
    
    public MissingAuthorizationException(String errorCode, String errorDesc) {
        super(errorCode, errorDesc);
    }
    
    public MissingAuthorizationException(ErrorResponse error) {
        super(error);
    }
}
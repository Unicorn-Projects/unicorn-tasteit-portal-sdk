package io.tasteit.rest.service.model.exception;

import io.tasteit.rest.service.model.response.ErrorResponse;

public class WeakPasswordException extends BadRequestException {
    
    private static final long serialVersionUID = -1L;
    
    public WeakPasswordException(String errorCode, String errorDesc) {
        super(errorCode, errorDesc);
    }
    
    public WeakPasswordException(ErrorResponse error) {
        super(error);
    }
}
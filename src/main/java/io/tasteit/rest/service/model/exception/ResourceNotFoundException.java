package io.tasteit.rest.service.model.exception;

import io.tasteit.rest.service.model.response.ErrorResponse;

public class ResourceNotFoundException extends BadRequestException {

    private static final long serialVersionUID = -1L;

    public ResourceNotFoundException(String errorCode, String errorDesc) {
        super(errorCode, errorDesc);
    }
    
    public ResourceNotFoundException(ErrorResponse error) {
        super(error);
    }
}
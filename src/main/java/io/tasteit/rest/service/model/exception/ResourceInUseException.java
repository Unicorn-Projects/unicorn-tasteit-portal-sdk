package io.tasteit.rest.service.model.exception;

import io.tasteit.rest.service.model.response.ErrorResponse;

public class ResourceInUseException extends BadRequestException {

    private static final long serialVersionUID = -1L;
    
    public ResourceInUseException(String errorCode, String errorDesc) {
        super(errorCode, errorDesc);
    }
    
    public ResourceInUseException(ErrorResponse error) {
        super(error);
    }
}
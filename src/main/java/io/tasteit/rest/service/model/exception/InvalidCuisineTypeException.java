package io.tasteit.rest.service.model.exception;

import io.tasteit.rest.service.model.response.ErrorResponse;

public class InvalidCuisineTypeException extends BadRequestException {
    
    private static final long serialVersionUID = -1;
    
    public InvalidCuisineTypeException(String errorCode, String errorDesc) {
        super(errorCode, errorDesc);
    }
    
    public InvalidCuisineTypeException(ErrorResponse error) {
        super(error);
    }
}

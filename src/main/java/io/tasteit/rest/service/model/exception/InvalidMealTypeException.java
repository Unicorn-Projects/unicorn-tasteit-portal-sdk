package io.tasteit.rest.service.model.exception;

import io.tasteit.rest.service.model.response.ErrorResponse;

public class InvalidMealTypeException extends BadRequestException {
    
    private static final long serialVersionUID = -1;
    
    public InvalidMealTypeException(String errorCode, String errorDesc) {
        super(errorCode, errorDesc);
    }
    
    public InvalidMealTypeException(ErrorResponse error) {
        super(error);
    }
}

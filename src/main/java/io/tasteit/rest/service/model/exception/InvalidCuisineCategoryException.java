package io.tasteit.rest.service.model.exception;

import io.tasteit.rest.service.model.response.ErrorResponse;

public class InvalidCuisineCategoryException extends BadRequestException {
    
    private static final long serialVersionUID = -1;
    
    public InvalidCuisineCategoryException(String errorCode, String errorDesc) {
        super(errorCode, errorDesc);
    }
    
    public InvalidCuisineCategoryException(ErrorResponse error) {
        super(error);
    }
}

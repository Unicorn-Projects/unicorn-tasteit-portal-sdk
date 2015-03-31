package io.tasteit.rest.service.model.exception;

import io.tasteit.rest.service.model.response.ErrorResponse;

public class BadRequestException extends TasteItServiceException {

    private static final long serialVersionUID = -1L;
    
    public BadRequestException(String errorCode, String errorDesc) {
        super(errorCode, errorDesc);
    }
    
    public BadRequestException(ErrorResponse error) {
        super(error);
    }
}
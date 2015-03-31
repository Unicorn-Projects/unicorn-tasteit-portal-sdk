package io.tasteit.rest.service.model.exception;

import io.tasteit.rest.service.model.response.ErrorResponse;

public class ForbiddenRequestException extends TasteItServiceException {

    private static final long serialVersionUID = -1L;
    
    public ForbiddenRequestException(String errorCode, String errorDesc) {
        super(errorCode, errorDesc);
    }
    
    public ForbiddenRequestException(ErrorResponse error) {
        super(error);
    }
}

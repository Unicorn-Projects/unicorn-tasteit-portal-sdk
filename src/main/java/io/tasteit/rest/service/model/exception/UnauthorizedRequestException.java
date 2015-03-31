package io.tasteit.rest.service.model.exception;

import io.tasteit.rest.service.model.response.ErrorResponse;

public class UnauthorizedRequestException extends TasteItServiceException {

    private static final long serialVersionUID = -1L;

    public UnauthorizedRequestException(String errorCode, String errorDesc) {
        super(errorCode, errorDesc);
    }
    
    public UnauthorizedRequestException(ErrorResponse error) {
        super(error);
    }
}

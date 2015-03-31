package io.tasteit.rest.service.model.exception;

import io.tasteit.rest.service.model.response.ErrorResponse;

public class AccessDeniedException extends ForbiddenRequestException {

    private static final long serialVersionUID = -1L;
    
    public AccessDeniedException(String errCode, String errorDesc) {
        super(errCode, errorDesc);
    }
    
    public AccessDeniedException(ErrorResponse error) {
        super(error);
    }
}
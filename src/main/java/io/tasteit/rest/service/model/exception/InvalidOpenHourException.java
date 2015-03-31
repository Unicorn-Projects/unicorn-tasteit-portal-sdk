package io.tasteit.rest.service.model.exception;

import io.tasteit.rest.service.model.response.ErrorResponse;

public class InvalidOpenHourException extends BadRequestException {

    private static final long serialVersionUID = -1L;

    public InvalidOpenHourException(String errorCode, String errorDesc) {
        super(errorCode, errorDesc);
    }
    
    public InvalidOpenHourException(ErrorResponse error) {
        super(error);
    }
}

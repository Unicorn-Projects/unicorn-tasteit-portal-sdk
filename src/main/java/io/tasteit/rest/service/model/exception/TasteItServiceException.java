package io.tasteit.rest.service.model.exception;

import io.tasteit.rest.service.model.response.ErrorResponse;

public class TasteItServiceException extends RuntimeException {

    private static final long serialVersionUID = -1L;

    // Status.BAD_REQUEST
    public final static String INVALID_REQUEST = "InvalidRequestException";
    public final static String INVALID_OPEN_HOUR = "InvalidOpenHourException";
    public final static String INVALID_CUISINE_CATEGORY = "InvalidCuisineCategoryException";
    public final static String INVALID_CUISINE_TYPE = "InvalidCuisineTypeException";
    public final static String INVALID_MEAL_TYPE = "InvalidMealTypeException";
    public final static String WEAK_PASSWORD = "WeakPasswordException";
    public final static String RESOURCE_IN_USE = "ResourceInUseException";
    public final static String RESOURCE_NOT_FOUND = "ResourceNotFoundException";
    // Status.UNAUTHORIZED
    public final static String MISSING_AUTHORIZATION = "MissingAuthorizationException";
    public final static String UNRECOGNIZED_SCHEME = "UnrecognizedAuthorizationSchemeException";
    public final static String UNRECOGNIZED_IDENTITY = "UnrecognizedIdentityException";
    // Status.FORBIDDEN
    public final static String ACCESS_DENIED = "AccessDeniedException";
    
    private String errorCode;
    private String errorDesc;
    
    public TasteItServiceException() {}
    
    public TasteItServiceException(String errorCode, String errorDesc) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    public TasteItServiceException(ErrorResponse error) {
        this(error.getErrorCode(), error.getErrorDesc());
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    @Override
    public String toString() {
        return  this.getClass().getSimpleName() + " [errorCode=" + errorCode
                + ", errorDesc=" + errorDesc + "]";
    }

    @Override
    public String getMessage() {
        return "[" + errorCode + "] " + errorDesc;
    }
}

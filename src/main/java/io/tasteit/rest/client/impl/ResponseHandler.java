package io.tasteit.rest.client.impl;

import io.tasteit.rest.activities.exception.BadRequestException;
import io.tasteit.rest.activities.exception.ForbiddenRequestException;
import io.tasteit.rest.activities.exception.InternalServerErrorException;
import io.tasteit.rest.activities.exception.UnauthorizedRequestException;
import io.tasteit.rest.activities.model.response.ErrorResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class ResponseHandler<T> {
    
    private final Class<T> type;
    
    public ResponseHandler(Class<T> type) {
        this.type = type;
    }
    
    public T readEntity(Response response) {
        if (response.getStatus() != Status.OK.getStatusCode()) {
            
            ErrorResponse error = response.readEntity(ErrorResponse.class);
            Response.Status status = Response.Status.fromStatusCode(response.getStatus());
            switch (status) {
            
            case BAD_REQUEST:
                throw new BadRequestException(error.getErrorCode(), error.getErrorDesc());
            case UNAUTHORIZED:
                throw new UnauthorizedRequestException(error.getErrorCode(), error.getErrorDesc());
            case FORBIDDEN:
                throw new ForbiddenRequestException(error.getErrorCode(), error.getErrorDesc());
            case INTERNAL_SERVER_ERROR:
                throw new InternalServerErrorException();
            default:
                break;
            }
            throw new RuntimeException();            
        }
        
        return response.readEntity(type);
    }
}

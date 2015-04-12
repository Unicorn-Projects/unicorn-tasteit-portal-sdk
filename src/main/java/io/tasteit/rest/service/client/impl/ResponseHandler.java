package io.tasteit.rest.service.client.impl;

import io.tasteit.rest.service.model.exception.AccessDeniedException;
import io.tasteit.rest.service.model.exception.BadRequestException;
import io.tasteit.rest.service.model.exception.ForbiddenRequestException;
import io.tasteit.rest.service.model.exception.InvalidOpenHourException;
import io.tasteit.rest.service.model.exception.InvalidRequestException;
import io.tasteit.rest.service.model.exception.MissingAuthorizationException;
import io.tasteit.rest.service.model.exception.ResourceInUseException;
import io.tasteit.rest.service.model.exception.ResourceNotFoundException;
import io.tasteit.rest.service.model.exception.TasteItClientException;
import io.tasteit.rest.service.model.exception.TasteItServiceException;
import io.tasteit.rest.service.model.exception.UnauthorizedRequestException;
import io.tasteit.rest.service.model.exception.UnrecognizedAuthorizationSchemeException;
import io.tasteit.rest.service.model.exception.UnrecognizedIdentityException;
import io.tasteit.rest.service.model.exception.WeakPasswordException;
import io.tasteit.rest.service.model.response.ErrorResponse;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class ResponseHandler {

    public static <T> T readEntity(Response response, Class<T> type) throws TasteItClientException, TasteItServiceException {
        try {
            checkException(response);
            return response.readEntity(type);
            
        } catch (ProcessingException | IllegalStateException error) {
            throw new TasteItClientException("Failed while attempting to read entity from response", error);
        }
    }
    
    public static void checkException(Response response) throws TasteItClientException, TasteItServiceException {
        try {
            if (response.getStatus() != Status.OK.getStatusCode()) {
                if (response.hasEntity()) {
                    ErrorResponse error = response.readEntity(ErrorResponse.class);
                    Response.Status status = Response.Status.fromStatusCode(response.getStatus());
                    
                    switch (status) {
                    case BAD_REQUEST:
                        switch (error.getErrorType()) {
                        case TasteItServiceException.INVALID_REQUEST:
                            throw new InvalidRequestException(error);
                        case TasteItServiceException.INVALID_OPEN_HOUR:
                            throw new InvalidOpenHourException(error);
                        case TasteItServiceException.WEAK_PASSWORD:
                            throw new WeakPasswordException(error);
                        case TasteItServiceException.RESOURCE_IN_USE:
                            throw new ResourceInUseException(error);
                        case TasteItServiceException.RESOURCE_NOT_FOUND:
                            throw new ResourceNotFoundException(error);
                        default:
                            throw new BadRequestException(error);
                        }
                    case UNAUTHORIZED:
                        switch (error.getErrorType()) {
                        case TasteItServiceException.MISSING_AUTHORIZATION:
                            throw new MissingAuthorizationException(error);
                        case TasteItServiceException.UNRECOGNIZED_SCHEME:
                            throw new UnrecognizedAuthorizationSchemeException(error);
                        case TasteItServiceException.UNRECOGNIZED_IDENTITY:
                            throw new UnrecognizedIdentityException(error);
                        default:
                            throw new UnauthorizedRequestException(error);
                        }
                    case FORBIDDEN:
                        switch (error.getErrorType()) {
                        case TasteItServiceException.ACCESS_DENIED:
                            throw new AccessDeniedException(error);
                        default:
                            throw new ForbiddenRequestException(error);
                        }
                    default:
                        throw new TasteItServiceException(error);
                    }
                } else {
                    System.out.println(response.getStatus());
                    throw new TasteItServiceException();
                } 
            }
        } catch (ProcessingException | IllegalStateException error) {
            throw new TasteItClientException("Failed while attempting to read entity from response", error);
        }
    }
}

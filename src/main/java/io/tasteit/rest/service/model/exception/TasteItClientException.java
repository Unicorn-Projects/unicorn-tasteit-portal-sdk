package io.tasteit.rest.service.model.exception;

public class TasteItClientException extends RuntimeException {

    private static final long serialVersionUID = -1L;
    
    public TasteItClientException(String message, Throwable cause) {
        super(message, cause);
    }
}

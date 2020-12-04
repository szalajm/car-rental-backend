package com.app.car.rental.backend.api.exception;

public class AvisApiException extends Exception {
    public AvisApiException(String message) {
        super(message);
    }

    public AvisApiException(String message, Throwable cause) {
        super(message, cause);
    }
}

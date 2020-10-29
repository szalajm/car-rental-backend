package com.app.car.rental.backend.api.exception;

public class ReservationNotMappedException extends ReservationException {
    public ReservationNotMappedException(String message) {
        super(message);
    }

    public ReservationNotMappedException(String message, Throwable cause) {
        super(message, cause);
    }
}

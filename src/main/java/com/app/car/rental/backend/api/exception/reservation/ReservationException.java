package com.app.car.rental.backend.api.exception.reservation;

public class ReservationException extends Exception {
    public ReservationException(String message) {
        super(message);
    }

    public ReservationException(String message, Throwable cause) {
        super(message, cause);
    }
}

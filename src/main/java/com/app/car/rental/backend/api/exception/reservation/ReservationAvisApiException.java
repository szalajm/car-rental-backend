package com.app.car.rental.backend.api.exception.reservation;

public class ReservationAvisApiException extends ReservationException {
    public ReservationAvisApiException(String message) {
        super(message);
    }

    public ReservationAvisApiException(String message, Throwable cause) {
        super(message, cause);
    }
}

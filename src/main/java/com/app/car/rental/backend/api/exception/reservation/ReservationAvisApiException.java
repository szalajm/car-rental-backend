package com.app.car.rental.backend.api.exception.reservation;

import com.app.car.rental.backend.api.exception.AvisApiException;

public class ReservationAvisApiException extends AvisApiException {
    public ReservationAvisApiException(String message) {
        super(message);
    }

    public ReservationAvisApiException(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.app.car.rental.backend.api.exception;

public class VehicleNotFoundException extends Exception {
    public VehicleNotFoundException() {
        super();
    }

    public VehicleNotFoundException(String message) {
        super(message);
    }
}

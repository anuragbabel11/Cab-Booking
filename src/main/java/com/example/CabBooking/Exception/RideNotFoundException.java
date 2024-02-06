package com.example.CabBooking.Exception;

public class RideNotFoundException extends RuntimeException{
    public RideNotFoundException(String message) {
        super(message);
    }
}

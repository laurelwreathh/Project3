package com.example.project3.util;

public class MeasurementErrorResponse {
    private String message;

    public MeasurementErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public MeasurementErrorResponse() {
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

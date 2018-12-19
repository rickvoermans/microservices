package com.rickvoermans.microservices.users.api.errors;

import java.time.LocalDate;

public class ErrorResponse {

    private LocalDate timestamp;

    private int statusCode;

    private String errorMessage;
    private String errorDetails;

    public ErrorResponse(LocalDate timestamp, int statusCode, String errorMessage, String errorDetails) {
        super();
        this.timestamp = timestamp;
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
        this.errorDetails = errorDetails;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }
}

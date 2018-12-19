package com.rickvoermans.microservices.users.api.models;

import java.time.LocalDate;

public class Response<T> {

    private LocalDate timestamp;

    private int statusCode;

    private String requestMethod;

    private T response;

    public Response(LocalDate timestamp, int statusCode, String requestMethod, T response) {
        this.timestamp = timestamp;
        this.statusCode = statusCode;
        this.requestMethod = requestMethod;
        this.response = response;
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

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}

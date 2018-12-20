package com.rickvoermans.microservices.users.api.errors;

import com.rickvoermans.microservices.users.api.errors.exceptions.ExistingUserException;
import com.rickvoermans.microservices.users.api.models.ErrorResponse;
import com.rickvoermans.microservices.users.api.models.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private ErrorResponse errorResponse;
    private Response response;

    /* USER ALREADY EXISTS ERROR */
    @ExceptionHandler(ExistingUserException.class)
    public final Response handleExistingUserException(ExistingUserException exception, WebRequest request) {
        errorResponse = new ErrorResponse(exception.getMessage(), request.getDescription(false));
        response = new Response<>(LocalDate.now(), HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT.toString(), errorResponse);

        return response;
    }

    /* DEFAULT ERROR (400) */
    @ExceptionHandler(Exception.class)
    public final Response handleGeneralException(Exception exception, WebRequest request) {
        errorResponse = new ErrorResponse(exception.getMessage(), request.getDescription(false));
        response = new Response<>(LocalDate.now(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.toString(), errorResponse);

        return response;
    }

}

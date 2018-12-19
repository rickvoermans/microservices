package com.rickvoermans.microservices.users.api.errors;

import com.rickvoermans.microservices.users.api.errors.exceptions.ExistingUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    /* USER ALREADY EXISTS ERROR */
    @ExceptionHandler(ExistingUserException.class)
    public final ResponseEntity<ErrorResponse> handleExistingUserException(ExistingUserException exception, WebRequest request) {
        errorResponse = new ErrorResponse(LocalDate.now(), HttpStatus.CONFLICT.value(), exception.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    /* DEFAULT ERROR (400) */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponse> handleGeneralException(Exception exception, WebRequest request) {
        errorResponse = new ErrorResponse(LocalDate.now(), HttpStatus.BAD_REQUEST.value(), exception.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}

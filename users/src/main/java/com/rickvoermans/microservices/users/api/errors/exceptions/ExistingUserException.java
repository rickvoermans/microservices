package com.rickvoermans.microservices.users.api.errors.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ExistingUserException extends RuntimeException {

    public ExistingUserException(String exception) {
        super(exception);
    }

}

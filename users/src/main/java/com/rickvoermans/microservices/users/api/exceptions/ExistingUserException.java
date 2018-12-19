package com.rickvoermans.microservices.users.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ExistingUserException extends RuntimeException {

    public ExistingUserException(String exception) {
        super(exception);
    }

}

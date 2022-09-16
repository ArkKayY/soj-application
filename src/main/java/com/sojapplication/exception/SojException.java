package com.sojapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class SojException extends RuntimeException {

    public SojException(final String message) {
        super(message);
    }

}

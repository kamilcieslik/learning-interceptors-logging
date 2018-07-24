package com.kamilcieslik.spring_boot.learninginterceptorslogging.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class InternalException extends RuntimeException {
    private HttpStatus httpStatus;

    public InternalException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}

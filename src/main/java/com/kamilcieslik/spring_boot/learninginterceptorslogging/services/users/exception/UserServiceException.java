package com.kamilcieslik.spring_boot.learninginterceptorslogging.services.users.exception;

import com.kamilcieslik.spring_boot.learninginterceptorslogging.utils.exceptions.model.ExceptionResponse;
import lombok.Getter;
import org.slf4j.MDC;

import java.util.Date;

@Getter
public class UserServiceException extends RuntimeException {
    private ExceptionResponse exceptionResponse;
    public UserServiceException(String message, String details) {
        super(message);
        exceptionResponse = new ExceptionResponse(new Date(), message, details, MDC.get("correlationId"));
    }
}

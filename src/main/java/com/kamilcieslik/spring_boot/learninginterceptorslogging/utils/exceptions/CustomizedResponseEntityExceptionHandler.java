package com.kamilcieslik.spring_boot.learninginterceptorslogging.utils.exceptions;

import com.kamilcieslik.spring_boot.learninginterceptorslogging.services.users.exception.UserServiceException;
import com.kamilcieslik.spring_boot.learninginterceptorslogging.utils.exceptions.model.ExceptionResponse;
import org.slf4j.MDC;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserServiceException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(UserServiceException ex, WebRequest request) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("correlationId", ex.getExceptionResponse().getCorrelationId());

        logger.error(ex.getExceptionResponse(), ex);

        return new ResponseEntity<>(ex.getExceptionResponse(), httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Nieudany proces walidacji.",
                ex.getBindingResult().toString(), MDC.get("correlationId"));

        logger.error("Validation failed", ex);

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}

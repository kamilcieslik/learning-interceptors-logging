package com.kamilcieslik.spring_boot.learninginterceptorslogging.utils.exceptions.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;
    private String correlationId;
}

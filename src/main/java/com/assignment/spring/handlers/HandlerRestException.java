package com.assignment.spring.handlers;

import com.assignment.spring.exceptions.ExceptionOpenweather;
import com.assignment.spring.models.ModelError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerRestException extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex, new ModelError(2000, ex.getMessage()),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> unknownException(ExceptionOpenweather ex, WebRequest request) {
        return handleExceptionInternal(ex, new ModelError(1000, ex.getMessage()),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(ExceptionOpenweather.class)
    protected ResponseEntity<Object> openWeatherException(ExceptionOpenweather ex, WebRequest request) {
        return handleExceptionInternal(ex, new ModelError(ex.getCode(), ex.getMessage()),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}

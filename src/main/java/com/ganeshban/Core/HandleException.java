package com.ganeshban.Core;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleException {
    @ExceptionHandler(NotFound.class)
    public ResponseEntity<String> notFoundException(NotFound notFound) {
        return new ResponseEntity<>(notFound.message, HttpStatus.NOT_FOUND);
    }
}
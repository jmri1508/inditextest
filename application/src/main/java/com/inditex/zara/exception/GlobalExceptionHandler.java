package com.inditex.zara.exception;

import com.inditex.zara.entity.RestErrorEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/** GlobalExceptionHandler */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<?> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                RestErrorEntity.builder()
                        .status(HttpStatus.BAD_REQUEST.value())
                        .description(ex.getMessage())
                        .build());
    }

    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<?> handlePriceNotFoundException(PriceNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                RestErrorEntity.builder()
                        .status(HttpStatus.NOT_FOUND.value())
                        .description(ex.getDescription())
                        .build());
    }

}

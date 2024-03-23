package com.shamolima.locationservice.utils;

import com.shamolima.locationservice.dto.ErrorOutput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorOutput> badRequestParamException(RuntimeException re) {
        return new ResponseEntity<>(new ErrorOutput("Bad message format"),
                HttpStatus.BAD_REQUEST);
    }
}

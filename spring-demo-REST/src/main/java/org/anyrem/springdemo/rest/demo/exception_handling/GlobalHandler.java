package org.anyrem.springdemo.rest.demo.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    private StudentErrorResponse studentErrorResponse(Exception ex, HttpStatus httpStatus) {
        StudentErrorResponse err = new StudentErrorResponse(
                httpStatus.value(),
                ex.getMessage(),
                System.currentTimeMillis()
        );

        return err;
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {

        return new ResponseEntity<>(studentErrorResponse(ex, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception ex) {

        return new ResponseEntity<>(studentErrorResponse(ex, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);

    }
}

package com.example.quiz.Exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class SeseException extends RuntimeException {

    private HttpStatus httpStatus;
    private int code;
    private String message;

    public SeseException(HttpStatus httpStatus, int code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }


}

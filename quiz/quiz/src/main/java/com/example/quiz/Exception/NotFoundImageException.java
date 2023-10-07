package com.example.quiz.Exception;

import org.springframework.http.HttpStatus;

public class NotFoundImageException extends SeseException{

    public NotFoundImageException(HttpStatus httpStatus, int code, String message) {
        super(httpStatus, code, message);
    }
}

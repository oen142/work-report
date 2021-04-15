package com.wani.workreport.auth.excpetion;

public class NotFoundLoginTypeException extends RuntimeException {

    public NotFoundLoginTypeException() {
    }

    public NotFoundLoginTypeException(String message) {
        super(message);
    }
}

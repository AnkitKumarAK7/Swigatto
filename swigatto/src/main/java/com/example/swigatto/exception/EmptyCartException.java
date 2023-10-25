package com.example.swigatto.exception;

public class EmptyCartException extends RuntimeException{

    public EmptyCartException(String message){
        super(message);
    }
}

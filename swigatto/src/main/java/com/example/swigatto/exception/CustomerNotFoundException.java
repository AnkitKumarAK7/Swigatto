package com.example.swigatto.exception;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(String message){
       super(message);
    }
}

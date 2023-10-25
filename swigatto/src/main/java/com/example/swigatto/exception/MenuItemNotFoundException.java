package com.example.swigatto.exception;

public class MenuItemNotFoundException extends RuntimeException{

    public MenuItemNotFoundException(String message){
        super(message);
    }
}

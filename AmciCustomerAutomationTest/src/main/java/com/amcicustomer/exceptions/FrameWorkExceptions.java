package com.amcicustomer.exceptions;

public class FrameWorkExceptions extends RuntimeException {

    public FrameWorkExceptions(String message){
        super(message);
    }
    public FrameWorkExceptions(String message,Throwable cause){
        super(message,cause);

    }
}

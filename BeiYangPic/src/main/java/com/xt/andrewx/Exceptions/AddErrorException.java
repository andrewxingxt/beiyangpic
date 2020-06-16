package com.xt.andrewx.Exceptions;

public class AddErrorException extends RuntimeException {
    public AddErrorException(Object message){
        super(message.toString());
    }
}

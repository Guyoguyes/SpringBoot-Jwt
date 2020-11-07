package com.example.springjwtapi.exceptions;

public class EtAuthException extends RuntimeException{

    public EtAuthException(String message){
        super(message);
    }
}

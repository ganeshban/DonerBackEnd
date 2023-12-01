package com.ganeshban.Core;


public class NotFound extends Exception{
    String message;

    public NotFound(String message) {
        super(message);
        this.message = message;
    }
}
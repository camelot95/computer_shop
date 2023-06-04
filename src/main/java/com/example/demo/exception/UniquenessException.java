package com.example.demo.exception;

public class UniquenessException extends RuntimeException {
    public UniquenessException(String msg) {
        super(msg);
    }
}
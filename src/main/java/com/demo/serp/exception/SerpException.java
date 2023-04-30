package com.demo.serp.exception;

public class SerpException extends Exception {

    public SerpException() {
        super();
    }

    public SerpException(String message) {
        super(message);
    }

    public SerpException(String message, Throwable cause) {
        super(message, cause);
    }

    public SerpException(Throwable cause) {
        super(cause);
    }

    protected SerpException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package com.qaqa.spring.xml;

/**
 * Created by thinkpad on 2018/6/28.
 */
public class UserAccoundException extends RuntimeException {


    private static final long serialVersionUID = 1L;

    public UserAccoundException() {
    }

    public UserAccoundException(String message) {
        super(message);
    }

    public UserAccoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAccoundException(Throwable cause) {
        super(cause);
    }

    public UserAccoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

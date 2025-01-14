package org.example.lookinsure.exception;

public abstract class BaseException extends RuntimeException {

    public BaseException(String desc) {
        super(desc);
    }

    public BaseException(String desc, Throwable cause) {
        super(desc, cause);
    }

    public abstract String getCode();

    public abstract String getDescriptionKey();

    public abstract int getHttpCode();

}

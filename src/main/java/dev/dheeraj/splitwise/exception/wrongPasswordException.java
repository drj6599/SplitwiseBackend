package dev.dheeraj.splitwise.exception;

public class wrongPasswordException extends RuntimeException {
    public wrongPasswordException() {
    }

    public wrongPasswordException(String message) {
        super(message);
    }

    public wrongPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public wrongPasswordException(Throwable cause) {
        super(cause);
    }

    public wrongPasswordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

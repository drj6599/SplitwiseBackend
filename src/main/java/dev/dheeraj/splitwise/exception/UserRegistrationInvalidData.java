package dev.dheeraj.splitwise.exception;

public class UserRegistrationInvalidData extends RuntimeException {

    public UserRegistrationInvalidData() {
    }

    public UserRegistrationInvalidData(String message) {
        super(message);
    }

    public UserRegistrationInvalidData(String message, Throwable cause) {
        super(message, cause);
    }

    public UserRegistrationInvalidData(Throwable cause) {
        super(cause);
    }

    protected UserRegistrationInvalidData(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

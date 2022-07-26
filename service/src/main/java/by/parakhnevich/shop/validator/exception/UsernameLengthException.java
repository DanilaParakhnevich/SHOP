package by.parakhnevich.shop.validator.exception;

public class UsernameLengthException extends RuntimeException {

    public UsernameLengthException() {
        super();
    }

    public UsernameLengthException(String message) {
        super(message);
    }

    public UsernameLengthException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameLengthException(Throwable cause) {
        super(cause);
    }

    protected UsernameLengthException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package by.parakhnevich.shop.validator.exception;

public class BadPasswordDesignException
        extends RuntimeException {

    public BadPasswordDesignException() {
        super();
    }

    public BadPasswordDesignException(String message) {
        super(message);
    }

    public BadPasswordDesignException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadPasswordDesignException(Throwable cause) {
        super(cause);
    }

    protected BadPasswordDesignException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

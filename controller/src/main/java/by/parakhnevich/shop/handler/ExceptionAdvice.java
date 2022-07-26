package by.parakhnevich.shop.handler;

import by.parakhnevich.shop.handler.response.Response;
import by.parakhnevich.shop.validator.exception.BadPasswordDesignException;
import by.parakhnevich.shop.validator.exception.PasswordLengthException;
import by.parakhnevich.shop.validator.exception.UserAlreadyExistsException;
import by.parakhnevich.shop.validator.exception.UsernameLengthException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static by.parakhnevich.shop.locale.Translator.toLocale;

@RestControllerAdvice
public class ExceptionAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadPasswordDesignException.class)
    public Response handleBadPasswordDesignException(BadPasswordDesignException exception) {
        return getDefaultLocalableException(exception);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserAlreadyExistsException.class)
    public Response handleUserAlreadyExistsException(UserAlreadyExistsException exception) {
        return getDefaultLocalableException(exception);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UsernameLengthException.class)
    public Response handleUsernameLengthException(UsernameLengthException exception) {
        return getDefaultLocalableException(exception);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PasswordLengthException.class)
    public Response handlePasswordLengthException(PasswordLengthException exception) {
        return getDefaultLocalableException(exception);
    }

    public Response getDefaultLocalableException(RuntimeException exception) {
        return new Response(getLocalizedMessage(exception.getMessage()));
    }

    public String getLocalizedMessage(String message) {
        String[] splitMessage = message.split("/");
        return splitMessage.length == 2 ?
                toLocale(splitMessage[0]) + " (" + splitMessage[1] + ")" :
                splitMessage[0];
    }
}

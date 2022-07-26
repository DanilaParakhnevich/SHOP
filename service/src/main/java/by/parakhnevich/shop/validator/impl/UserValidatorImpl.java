package by.parakhnevich.shop.validator.impl;

import by.parakhnevich.shop.dto.UserDTO;
import by.parakhnevich.shop.repository.UserRepository;
import by.parakhnevich.shop.validator.UserValidator;
import by.parakhnevich.shop.validator.exception.BadPasswordDesignException;
import by.parakhnevich.shop.validator.exception.PasswordLengthException;
import by.parakhnevich.shop.validator.exception.UserAlreadyExistsException;
import by.parakhnevich.shop.validator.exception.UsernameLengthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@Scope(scopeName = "singleton")
public class UserValidatorImpl implements UserValidator {
    UserRepository userRepository;

    @Override
    public void validate(UserDTO user) {
        validateUsername(user.getUsername());
        validatePassword(user.getPassword());
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistsException("user.already.exists/username=" + user.getUsername());
        }
    }

    private void validatePassword(String password) {
        if (password == null ||
                password.length() < 6) {
            throw new PasswordLengthException("password.bad.length/length=" +
                    (password == null ? 0 : password.length()));
        } else if (password.equals(password.toLowerCase(Locale.ROOT))) {
            throw new BadPasswordDesignException("password.at.least.one.uppercase.letter");
        }
    }

    private void validateUsername(String username) {
        if (username == null ||
                username.length() <= 4 ||
                username.length() > 24) {
            throw new UsernameLengthException("username.bad.length/" +
                    (username == null ? 0 : username.length()));
        }
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}

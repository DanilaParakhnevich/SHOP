package by.parakhnevich.shop.impl;

import by.parakhnevich.shop.PasswordService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(scopeName = "singleton")
public class PasswordServiceImpl implements PasswordService {
    @Override
    public String encryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public boolean comparePasswords(String password, String encryptedPassword) {
        return BCrypt.checkpw(password, encryptedPassword);
    }
}

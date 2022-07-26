package by.parakhnevich.shop;

public interface PasswordService {
    String encryptPassword(String password);

    boolean comparePasswords(String password, String encryptedPassword);
}
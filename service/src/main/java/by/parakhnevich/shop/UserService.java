package by.parakhnevich.shop;

import by.parakhnevich.shop.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> readAll();

    UserDTO createOrUpdate(UserDTO user);
}

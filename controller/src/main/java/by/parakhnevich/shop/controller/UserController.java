package by.parakhnevich.shop.controller;

import by.parakhnevich.shop.UserService;
import by.parakhnevich.shop.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;

    @PostMapping("/create")
    public UserDTO create(@RequestBody UserDTO user) {
        return userService.createOrUpdate(user);
    }

    @GetMapping("/all")
    public List<UserDTO> readAll() {
        return userService.readAll();
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

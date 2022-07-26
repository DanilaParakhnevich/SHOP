package by.parakhnevich.shop.impl;

import by.parakhnevich.shop.PasswordService;
import by.parakhnevich.shop.UserService;
import by.parakhnevich.shop.dto.UserDTO;
import by.parakhnevich.shop.mapper.UserMapper;
import by.parakhnevich.shop.repository.UserRepository;
import by.parakhnevich.shop.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Scope(scopeName = "singleton")
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    UserMapper userMapper;
    PasswordService passwordService;
    UserValidator userValidator;

    @Override
    public List<UserDTO> readAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> userMapper.toDTO(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO createOrUpdate(UserDTO user) {
        user.setCreationTime(LocalDateTime.now());
        user.setLastUpdateTime(user.getCreationTime());
        userValidator.validate(user);
        user.setPassword(passwordService.encryptPassword(user.getPassword()));
        return userMapper
                .toDTO(userRepository
                        .save(userMapper.toEntity(user)));
    }

    @Autowired
    public void setUserValidator(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    @Autowired
    public void setPasswordService(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}

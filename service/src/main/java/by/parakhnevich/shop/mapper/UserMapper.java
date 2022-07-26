package by.parakhnevich.shop.mapper;

import by.parakhnevich.shop.dto.UserDTO;
import by.parakhnevich.shop.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(UserDTO user);

    UserDTO toDTO(UserEntity user);
}
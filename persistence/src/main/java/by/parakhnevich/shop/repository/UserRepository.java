package by.parakhnevich.shop.repository;

import by.parakhnevich.shop.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
        extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);
}

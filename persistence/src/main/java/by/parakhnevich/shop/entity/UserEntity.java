package by.parakhnevich.shop.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "\"user\"")
@Entity
public class UserEntity extends AbstractEntity {
    @Column
    private String username;
    @Column
    private String password;
}

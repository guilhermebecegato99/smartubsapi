package com.smartubs.model.user;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "users")
@Entity(name = "Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String password;
    private String login;

    public Users(CreateUserDTO userDTO){
        this.login = userDTO.getLogin();
        this.password = userDTO.getPassword();
    }
}

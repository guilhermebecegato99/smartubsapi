package com.smartubs.model.user;

import com.smartubs.model.person.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateUserDTO {

    private String login;
    private String password;
}

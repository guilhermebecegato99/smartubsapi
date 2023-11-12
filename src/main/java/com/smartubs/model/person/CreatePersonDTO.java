package com.smartubs.model.person;

import com.smartubs.model.user.CreateUserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePersonDTO {

    private CreateUserDTO users;
    private String name;
    private String email;
    private String document;
    private LocalDate birthDate;
    private PersonSex personSex;
    private String cardSUSNumber;
    private String phone;
}

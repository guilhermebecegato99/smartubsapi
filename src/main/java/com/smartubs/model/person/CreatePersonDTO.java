package com.smartubs.model.person;

import com.smartubs.model.user.CreateUserDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class CreatePersonDTO {

    private CreateUserDTO user;
    private String name;
    private String email;
    private String document;
    private LocalDate birthDate;
    private PersonSex personSex;
    private String cardSUSNumber;
}

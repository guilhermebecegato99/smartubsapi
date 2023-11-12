package com.smartubs.model.person;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@Getter
public class PersonDTO {

    private UUID id;
    private String name;
    private String email;
    private String document;
    private LocalDate birthDate;
    private String cardSUSNumber;

    public PersonDTO(Person person){
        this.id = person.getId();
        this.name = person.getName();
        this.email = person.getEmail();
        this.document = person.getDocument();
        this.birthDate = person.getBirthDate();
        this.cardSUSNumber = person.getCardSUSNumber();
    }
}

package com.smartubs.model.person;

import com.smartubs.model.user.Users;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "person")
@Entity(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String email;
    private String document;
    private DoctorSpeciality doctorSpeciality;
    private LocalDate birthDate;
    private PersonSex personSex;
    private String cardSUSNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Users users;

    public Person(CreatePersonDTO personDTO){
        this.birthDate = personDTO.getBirthDate();
        this.cardSUSNumber = personDTO.getCardSUSNumber();
        this.name = personDTO.getName();
        this.email = personDTO.getEmail();
        this.users = new Users(personDTO.getUser());
    }

    public void update(UpdatePersonDTO updatePersonDTO){

        if(Objects.nonNull(updatePersonDTO.getBirthDate())){
            this.birthDate = updatePersonDTO.getBirthDate();
        }

        if(Objects.nonNull(updatePersonDTO.getName())){
            this.name = updatePersonDTO.getName();
        }

        if(Objects.nonNull(updatePersonDTO.getCardSUSNumber())){
            this.cardSUSNumber = updatePersonDTO.getCardSUSNumber();
        }

        if(Objects.nonNull(updatePersonDTO.getEmail())){
            this.email = updatePersonDTO.getEmail();
        }

        if(Objects.nonNull(updatePersonDTO.getDoctorSpeciality())){
            this.doctorSpeciality = updatePersonDTO.getDoctorSpeciality();
        }
    }
}

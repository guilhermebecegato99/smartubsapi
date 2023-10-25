package com.smartubs.model.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdatePersonDTO {

    private String name;
    private String email;
    private DoctorSpeciality doctorSpeciality;
    private LocalDate birthDate;
    private String cardSUSNumber;
}

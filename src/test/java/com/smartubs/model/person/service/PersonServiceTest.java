package com.smartubs.model.person.service;

import com.smartubs.model.person.*;
import com.smartubs.model.user.CreateUserDTO;
import com.smartubs.repository.PersonRepository;
import com.smartubs.service.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class PersonServiceTest {

    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonRepository personRepository;

    @Test
    void shouldCreatePersonSucceed() {
        Person person = new Person(createPersonDTOMock());

        when(personRepository.save(any())).thenReturn(person);

        assertDoesNotThrow(() -> personService.create(createPersonDTOMock()));
        verify(personRepository).save(any());
    }

    @Test
    void shouldListAllPersonsSucceed() {
        List<Person> personsList = Arrays.asList(new Person(createPersonDTOMock()), new Person(createPersonDTOMock()));

        when(personRepository.findAll()).thenReturn(personsList);

        assertDoesNotThrow(() -> personService.listAll());
        verify(personRepository).findAll();
    }

    @Test
    void shouldUpdatePersonSucceed() {
        Person person = new Person(createPersonDTOMock());
        UUID id = UUID.randomUUID();

        when(personRepository.findById(any())).thenReturn(Optional.of(person));
        when(personRepository.save(any())).thenReturn(person);

        assertDoesNotThrow(() -> personService).update(id, updatePersonDTOMock());
        assertAll(() -> verify(personRepository).findById(any()),
                  () -> verify(personRepository).save(any())
        );
    }

    @Test
    void shouldDeletePersonSucceed() {
        Person person = new Person(createPersonDTOMock());
        UUID id = UUID.randomUUID();

        when(personRepository.findById(any())).thenReturn(Optional.of(person));

        assertDoesNotThrow(() -> personService.delete(id));
        verify(personRepository).findById(any());
    }

    private CreatePersonDTO createPersonDTOMock() {
        CreateUserDTO userDTO = new CreateUserDTO();
        LocalDate birthDate = LocalDate.now();
        PersonSex personSex = PersonSex.MALE;
        return new CreatePersonDTO(userDTO, "name", "email@email", "document", birthDate, personSex, "cardNumber");
    }

    private UpdatePersonDTO updatePersonDTOMock() {
        DoctorSpeciality speciality = DoctorSpeciality.PHYSIOTHERAPIST;
        LocalDate birthDate = LocalDate.now();
        return new UpdatePersonDTO("name", "email@email", speciality, birthDate, "cardNumber");
    }
}

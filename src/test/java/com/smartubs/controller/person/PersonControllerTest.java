package com.smartubs.controller.person;

import com.smartubs.controller.PersonController;
import com.smartubs.model.person.*;
import com.smartubs.model.user.CreateUserDTO;
import com.smartubs.service.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class PersonControllerTest {

    @InjectMocks
    private PersonController personController;

    @Mock
    private PersonService personService;

    @Test
    void shouldCreatePersonSucceed() {
        CreatePersonDTO personDTO = createPersonDTOMock();

        doNothing().when(personService).create(personDTO);

        ResponseEntity<?> responseEntity = personController.createPerson(personDTO);

        verify(personService).create(personDTO);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void shouldListAllPersonsSucceed() {
        List<PersonDTO> personsDTO = new ArrayList<>();

        when(personService.listAll()).thenReturn(personsDTO);

        ResponseEntity<?> responseEntity = personController.listAll();

        verify(personService).listAll();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void shouldUpdatePersonSucceed() {
        UUID id = UUID.randomUUID();
        UpdatePersonDTO updatePersonDTO = updatePersonDTOMock();

        doNothing().when(personService).update(id, updatePersonDTO);

        ResponseEntity<?> responseEntity = personController.update(id, updatePersonDTO);

        verify(personService).update(id, updatePersonDTO);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void shouldDeletePersonSucceed() {
        UUID id = UUID.randomUUID();

        doNothing().when(personService).delete(id);

        ResponseEntity<?> responseEntity = personController.delete(id);

        verify(personService).delete(id);
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
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

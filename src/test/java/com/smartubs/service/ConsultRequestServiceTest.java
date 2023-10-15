package com.smartubs.service;

import com.smartubs.model.consult.ConsultRequest;
import com.smartubs.model.consult.CreateConsultRequestDTO;
import com.smartubs.model.person.Person;
import com.smartubs.repository.ConsultRequestRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class ConsultRequestServiceTest {

    @InjectMocks
    private ConsultRequestService consultRequestService;

    @Mock
    private ConsultRequestRepository consultRequestRepository;

    @Mock
    private PersonService personService;

    @Mock
    private CreateConsultRequestDTO dto;

    @Mock
    private ConsultRequest consultRequest;

    @Mock
    private Person person;

    @Test
    void shouldSaveNewConsultRequest() {
        given(dto.patientId()).willReturn(UUID.randomUUID());
        given(personService.findById(dto.patientId())).willReturn(person);

        consultRequestService.create(dto);

        then(consultRequestRepository).should().save(any());
    }

}
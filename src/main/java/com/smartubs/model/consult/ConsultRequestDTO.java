package com.smartubs.model.consult;

import com.smartubs.model.person.PersonDTO;

import java.time.LocalDateTime;
import java.util.UUID;

public record ConsultRequestDTO(
        UUID id,
        PersonDTO patient,
        LocalDateTime consultDate,
        LocalDateTime createdAt,
        LocalDateTime lastModifiedAt,
        String details,
        ConsultRequestStatus status,
        ConsultPriority priority
) {
    public ConsultRequestDTO(ConsultRequest consultRequest) {
        this(
                consultRequest.getId(),
                new PersonDTO(consultRequest.getPatient()),
                consultRequest.getConsultDate(),
                consultRequest.getCreatedAt(),
                consultRequest.getLastModifiedAt(),
                consultRequest.getDetails(),
                consultRequest.getStatus(),
                consultRequest.getConsultPriority()
        );
    }
}

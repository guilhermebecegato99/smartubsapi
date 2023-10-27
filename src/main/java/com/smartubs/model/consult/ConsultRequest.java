package com.smartubs.model.consult;

import com.smartubs.model.person.Person;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "consult_request")
@Entity(name = "ConsultRequest")
public class ConsultRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Person patient;
    private LocalDateTime consultDate;
    private ConsultPriority consultPriority;
    private String modifiedBy;
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;
    private ConsultRequestStatus status;
    private String details;

    public ConsultRequest(CreateConsultRequestDTO dto, Person patient) {
        this.patient = patient;
        this.consultDate = dto.realizationConsultDate();
        this.consultPriority = dto.priority();
        this.createdAt = LocalDateTime.now();
        this.lastModifiedAt = LocalDateTime.now();
        this.status = ConsultRequestStatus.OPEN;
        this.details = dto.details();
    }

    public void update(UpdateConsultRequestDTO dto) {
        if (Objects.nonNull(dto.details())) {
            this.details = dto.details();
        }
        if (Objects.nonNull(dto.consultDate())) {
            this.consultDate = dto.consultDate();
        }
        if (Objects.nonNull(dto.priority())) {
            this.consultPriority = dto.priority();
        }
        if (Objects.nonNull(dto.status())) {
            this.status = dto.status();
        }
    }
}

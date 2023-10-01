package com.smartubs.model.consult;

import com.smartubs.model.person.Person;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
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
}

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
@Table(name = "consult")
@Entity(name = "Consult")
public class Consult {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Person doctor;

    @Column(name = "medical_report")
    private String medicalReport;
    @OneToOne
    @JoinColumn(name = "consult_request_id")
    private ConsultRequest consultRequest;
    private String modifiedBy;
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;
    private ConsultStatus status;
    private Boolean remote;
    private String callLink;
}

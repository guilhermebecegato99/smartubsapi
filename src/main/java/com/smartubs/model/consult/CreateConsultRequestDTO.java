package com.smartubs.model.consult;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateConsultRequestDTO(
        UUID patientId,
        LocalDateTime realizationConsultDate,
        ConsultPriority priority,
        String details
) {
}

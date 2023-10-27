package com.smartubs.model.consult;

import java.time.LocalDateTime;

public record UpdateConsultRequestDTO(
        String details,
        ConsultRequestStatus status,
        ConsultPriority priority,
        LocalDateTime consultDate
) {
}

package com.smartubs.repository;

import com.smartubs.model.consult.Consult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConsultRepository extends JpaRepository<Consult, UUID> {
}

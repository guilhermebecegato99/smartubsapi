package com.smartubs.service;

import com.smartubs.model.consult.ConsultRequest;
import com.smartubs.model.consult.ConsultRequestDTO;
import com.smartubs.model.consult.CreateConsultRequestDTO;
import com.smartubs.model.consult.UpdateConsultRequestDTO;
import com.smartubs.repository.ConsultRequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ConsultRequestService {

    @Autowired
    private ConsultRequestRepository consultRequestRepository;

    @Autowired
    private PersonService personService;

    public ConsultRequestDTO create(CreateConsultRequestDTO dto) {
        var person = personService.findById(dto.patientId());

        var consultRequest = new ConsultRequest(dto, person);
        consultRequestRepository.save(consultRequest);
        return new ConsultRequestDTO(consultRequest);
    }

    public List<ConsultRequestDTO> listAll() {
        return consultRequestRepository.findAll().stream()
                .map(ConsultRequestDTO::new)
                .collect(Collectors.toList());
    }

    public ConsultRequestDTO update(UUID id, UpdateConsultRequestDTO dto) {
        var consultRequest = findById(id);
        consultRequest.update(dto);
        return new ConsultRequestDTO(consultRequestRepository.save(consultRequest));
    }

    public ConsultRequest findById(UUID id) {
        return consultRequestRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Consult Request not found!"));
    }
}

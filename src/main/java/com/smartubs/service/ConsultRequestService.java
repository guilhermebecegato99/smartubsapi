package com.smartubs.service;

import com.smartubs.model.consult.ConsultRequest;
import com.smartubs.model.consult.ConsultRequestDTO;
import com.smartubs.model.consult.CreateConsultRequestDTO;
import com.smartubs.model.consult.UpdateConsultRequestDTO;
import com.smartubs.msg.Destination;
import com.smartubs.msg.Message;
import com.smartubs.msg.MessageClient;
import com.smartubs.msg.MessageDTO;
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

    @Autowired
    private MessageClient messageClient;

    public ConsultRequestDTO create(CreateConsultRequestDTO dto) {
        var person = personService.findById(dto.patientId());

        var consultRequest = new ConsultRequest(dto, person);
        consultRequestRepository.save(consultRequest);

        var text = """
                Sua consulta foi solicitada e esta em processo de avaliacao e logo entraremos em contato com mais informacoes;
                """;

        var message = new MessageDTO(List.of(new Message(List.of(new Destination(person.getPhone())), text)));
        messageClient.sendMessage(message);
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

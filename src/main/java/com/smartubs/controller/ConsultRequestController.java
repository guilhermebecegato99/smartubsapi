package com.smartubs.controller;

import com.smartubs.model.consult.ConsultRequest;
import com.smartubs.model.consult.ConsultRequestDTO;
import com.smartubs.model.consult.CreateConsultRequestDTO;
import com.smartubs.model.consult.UpdateConsultRequestDTO;
import com.smartubs.service.ConsultRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/consult-request")
public class ConsultRequestController {

    @Autowired
    private ConsultRequestService consultRequestService;

    @PostMapping
    public ResponseEntity<ConsultRequestDTO> create(@RequestBody CreateConsultRequestDTO dto) {
        var newConsultRequest = consultRequestService.create(dto);
        return ResponseEntity.ok(newConsultRequest);
    }

    @GetMapping
    public ResponseEntity<List<ConsultRequestDTO>> listAll() {
        var consultsRequests = consultRequestService.listAll();
        return ResponseEntity.ok(consultsRequests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultRequest> findById(@PathVariable UUID id) {
        var idToFind = consultRequestService.findById(id);
        return ResponseEntity.ok(idToFind);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultRequestDTO> update(@PathVariable UUID id, @RequestBody UpdateConsultRequestDTO dto) {
        var consultRequestUpdated = consultRequestService.update(id, dto);
        return ResponseEntity.ok(consultRequestUpdated);
    }
}

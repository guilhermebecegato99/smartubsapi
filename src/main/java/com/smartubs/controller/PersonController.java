package com.smartubs.controller;

import com.smartubs.model.person.CreatePersonDTO;
import com.smartubs.model.person.PersonDTO;
import com.smartubs.model.person.UpdatePersonDTO;
import com.smartubs.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<?> createPerson(@RequestBody CreatePersonDTO createPersonDTO){

        personService.create(createPersonDTO);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> listAll(){

        List<PersonDTO> personList = personService.listAll();

        return ResponseEntity.ok(personList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody UpdatePersonDTO updatePersonDTO){

        personService.update(id, updatePersonDTO);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){

        personService.delete(id);

        return ResponseEntity.noContent().build();
    }
}

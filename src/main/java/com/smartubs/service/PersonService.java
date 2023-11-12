package com.smartubs.service;

import com.smartubs.model.person.UpdatePersonDTO;
import com.smartubs.model.person.PersonDTO;
import com.smartubs.model.person.CreatePersonDTO;
import com.smartubs.model.person.Person;
import com.smartubs.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public PersonDTO create(CreatePersonDTO personDTO){
        Person person = new Person(personDTO);
        return new PersonDTO(personRepository.save(person));
    }

    public List<PersonDTO> listAll(){
        return personRepository.findAll().stream().map(PersonDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public void update(UUID id, UpdatePersonDTO updatePersonDTO){

        Person person = findById(id);

        person.update(updatePersonDTO);

        personRepository.save(person);
    }

    @Transactional
    public void delete(UUID id){
        Person person = findById(id);

        personRepository.delete(person);
    }

    public Person findById(UUID personId) {
        return personRepository.findById(personId).orElseThrow(RuntimeException::new);
    }

    public Person findByUserId(UUID userId) {
        return personRepository.findByUsersId(userId).orElseThrow(() -> new RuntimeException("Pessoa nao encontrada!"));
    }
}

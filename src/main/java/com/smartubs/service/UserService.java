package com.smartubs.service;

import com.smartubs.model.person.Person;
import com.smartubs.model.person.PersonDTO;
import com.smartubs.model.user.CreateUserDTO;
import com.smartubs.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PersonService personService;

    public PersonDTO login(CreateUserDTO userDTO) {
        var user = usersRepository.findByLoginAndPassword(userDTO.getLogin(), userDTO.getPassword())
                .orElseThrow(() -> new RuntimeException("Login e/ou senha incorreta!"));
        var person = personService.findByUserId(user.getId());
        return new PersonDTO(person);
    }
}

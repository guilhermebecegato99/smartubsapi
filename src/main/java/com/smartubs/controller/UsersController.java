package com.smartubs.controller;

import com.smartubs.model.person.PersonDTO;
import com.smartubs.model.user.CreateUserDTO;
import com.smartubs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UsersController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<PersonDTO> login(@RequestBody CreateUserDTO userDTO) {
        return ResponseEntity.ok(userService.login(userDTO));
    }
}

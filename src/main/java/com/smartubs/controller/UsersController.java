package com.smartubs.controller;

import com.smartubs.msg.Destination;
import com.smartubs.msg.Message;
import com.smartubs.msg.MessageClient;
import com.smartubs.msg.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UsersController {

    @Autowired
    private MessageClient messageClient;

    @GetMapping
    public String sendMessage() {
        var messageDTO = new MessageDTO(List.of(new Message(List.of(new Destination("5544991149674")), "Teste")));
        messageClient.sendMessage(messageDTO);
        return "Deu bom";
    }
}

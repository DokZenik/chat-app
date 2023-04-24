package com.example.testchatwithreact.controller;

import com.example.testchatwithreact.model.MessageDTO;
import com.example.testchatwithreact.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MessageController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    private final StorageService storageService;

    @MessageMapping("/message")
    public ResponseEntity<Void> receivePublicMessages(@Payload MessageDTO message){
        if(message.getStatus().name().equals("JOIN"))
            storageService.addUser(message.getSenderName());
        else {
            simpMessagingTemplate.convertAndSend("/chatroom/" + message.getRecipientName(), message);
        }
//        System.out.println(storageService.getAll());
        return ResponseEntity.ok().build();
    }
}

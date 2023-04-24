package com.example.testchatwithreact.controller;

import com.example.testchatwithreact.model.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/message")
    public ResponseEntity<Void> receivePublicMessages(@Payload MessageDTO message){
        simpMessagingTemplate.convertAndSend("/chatroom/" + message.getRecipientName(), message);
        return ResponseEntity.ok().build();
    }
}

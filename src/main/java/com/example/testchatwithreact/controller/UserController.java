package com.example.testchatwithreact.controller;

import com.example.testchatwithreact.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final StorageService storageService;

    @GetMapping("/allUsers")
    public ResponseEntity<Set<String>> getAll(){
        return ResponseEntity.ok(storageService.getAll());
    }

    @PostMapping("/addUser")
    public ResponseEntity<Boolean> addUser(@RequestParam String username){
        if(!storageService.addUser(username))
            return ResponseEntity.badRequest().body(false);
        return ResponseEntity.ok(true);
    }
}

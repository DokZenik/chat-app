package com.example.testchatwithreact.controller;

import com.example.testchatwithreact.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
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

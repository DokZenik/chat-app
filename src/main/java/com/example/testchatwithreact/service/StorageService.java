package com.example.testchatwithreact.service;

import com.example.testchatwithreact.model.Storage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class StorageService {
    private final Storage storage = Storage.getInstance();

    public boolean addUser(String user){
        return storage.addUser(user);
    }
    public Set<String> getAll(){
        return storage.getAll();
    }
}

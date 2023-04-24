package com.example.testchatwithreact.model;

import java.util.HashSet;
import java.util.Set;

public class Storage {
    private static Set<String> users = new HashSet<>();
    private static Storage storage;
    private Storage(){}
    public static Storage getInstance(){
        if(storage == null)
            storage = new Storage();
        return storage;
    }
    public boolean addUser(String user){
        if(users.contains(user))
            return false;
        users.add(user);
        return true;
    }
    public Set<String> getAll(){
        return users;
    }
}

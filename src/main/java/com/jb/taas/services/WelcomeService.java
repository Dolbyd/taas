package com.jb.taas.services;

import com.jb.taas.exceptions.TaskSecurityException;

import java.util.UUID;

public interface WelcomeService {

    void register(String email,String password) throws TaskSecurityException;
    UUID login(String email,String password) throws TaskSecurityException;

}
package com.poweroutine.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EncriptedPasswd {
    private PasswordEncoder passwordEncoder;

    public EncriptedPasswd() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public String encriptar(String password){
        return passwordEncoder.encode(password);
    }
    public boolean comparar(String password,String encriptadaPasswd){
        return passwordEncoder.matches(password,encriptadaPasswd);
    }
}

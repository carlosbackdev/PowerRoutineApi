package com.poweroutine.controller;

import com.poweroutine.dtd.LoginUserDTD;
import com.poweroutine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.poweroutine.model.UserModel;


@RestController
@RequestMapping("user")
public class UserControl {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    public ResponseEntity<LoginUserDTD> login(@RequestBody UserModel user){
        LoginUserDTD respuesta= userService.login(user);
        System.out.println(user.toString());
        if(respuesta.getUsermodel() != null){
            return ResponseEntity.ok(respuesta);
        }else{
            return ResponseEntity.status(401)
                    .body(new LoginUserDTD( null,"Invalid credentials"));
        }

    }
}

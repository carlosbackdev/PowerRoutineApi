package com.poweroutine.controller;

import com.poweroutine.dtd.LoginUserDTD;
import com.poweroutine.dtd.RegisterUserDTD;
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

        if(respuesta.getUserModel() != null){
            return ResponseEntity.ok(respuesta);
        }else{
            return ResponseEntity.status(401).body(respuesta);
        }

    }
    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody UserModel user){
        RegisterUserDTD respuesta= userService.register(user);
        boolean registrado=respuesta.isSucessful();
        if(registrado){
            return ResponseEntity.ok(respuesta.getRespuesta());
        }else{

            return ResponseEntity.status(401).body(respuesta.getRespuesta());
        }
    }
    @PostMapping("update")
    public ResponseEntity<LoginUserDTD> update(@RequestBody UserModel user){
        System.out.println("usuario a cambiar:"+user.toString());
        LoginUserDTD respuesta= userService.update(user);
        if(respuesta.getUserModel() != null){
            return ResponseEntity.ok(respuesta);
        }else{
            return ResponseEntity.status(401).body(respuesta);
        }
    }

    @PostMapping("delete")
    public boolean delete(@RequestBody UserModel user){
        if(userService.deleteUser(user)){
            return true;
        }
        return false;
    }

}

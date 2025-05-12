package com.poweroutine.controller;

import com.poweroutine.dtd.UserCompletesDTD;
import com.poweroutine.model.UserCompletesModel;
import com.poweroutine.model.UserModel;
import com.poweroutine.service.UserCompletesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("userCompletes")
public class UserCompletesControl {
    private UserCompletesDTD userCompletesDTD=new UserCompletesDTD();

    @Autowired
    private UserCompletesService userCompletesService;

    @PostMapping("getUserCompletes")
    public ResponseEntity<UserCompletesDTD> getAllUserCompletes(@RequestBody UserModel user){
        try{
            userCompletesDTD = userCompletesService.getAllCompleteByUser(user);
            if(userCompletesDTD.getRespuesta().contains("Items encontrados")) {
                System.out.println("A ENVIAR: "+userCompletesDTD);
                return ResponseEntity.ok(userCompletesDTD);
            }else{
                userCompletesDTD.setUserCompletesModel(null);
                return ResponseEntity.ok(userCompletesDTD);
            }
        }catch (Exception e){
            return ResponseEntity.status(404).body(userCompletesDTD);
        }
    }

    @PostMapping("isComplete")
    public boolean isComplete(@RequestBody UserCompletesModel userCompletesModel){
        if(userCompletesService.SaveUserCompletes(userCompletesModel)){
            return true;
        }
        return false;
    }

}

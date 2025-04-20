package com.poweroutine.controller;

import com.poweroutine.dtd.RutineDTD;
import com.poweroutine.model.UserModel;
import com.poweroutine.service.RutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rutine")
public class RutineControl {

    @Autowired
    RutineService rutineService;


    @PostMapping("getRutine")
    public ResponseEntity<RutineDTD> getRutine(@RequestBody UserModel user){
        Integer dayweek = user.getDaysWeek();
        RutineDTD rutines = rutineService.getRutine(dayweek);
        System.out.println(rutines.getRespuesta()+ rutines.getRutinas().toString());

        if(!rutines.getRutinas().isEmpty() && rutines.getRespuesta().contains("Rutinas encontradas")) {
            System.out.println(rutines.getRutinas());
            return ResponseEntity.ok(rutines);
        }
        return ResponseEntity.status(404).body(rutines);
    }

    @PostMapping("saveRutineUser")
    public ResponseEntity<String> saveRutineUser(@RequestBody RutineDTD rutine){
        String respuesta = rutineService.saveRutineUser(rutine);
        if(respuesta.contains("correctamente")){
            System.out.println(respuesta);
            return ResponseEntity.ok(respuesta);
        }else{
            System.out.println(respuesta);
            return ResponseEntity.status(401).body(respuesta);
        }

    }

}

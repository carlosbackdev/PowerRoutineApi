package com.poweroutine.controller;

import com.poweroutine.dtd.EjerciceDTD;
import com.poweroutine.dtd.RutineDTD;
import com.poweroutine.model.RutineModel;
import com.poweroutine.service.EjerciceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("ejercice")
public class EjerciceControl {

    @Autowired
    EjerciceService ejerciceService;

    @PostMapping("getEjercices")
    public ResponseEntity<EjerciceDTD> getEjercice(@RequestBody RutineDTD rutines){
        System.out.println(rutines.toString());
        List<Long> idEjercices= new ArrayList<>();
        for(RutineModel rutine: rutines.getRutinas()){
            for (Integer id : rutine.getIdEjercices()) {
                idEjercices.add(id.longValue());
            }
        }
        EjerciceDTD ejerciciosData = ejerciceService.getEjercices(idEjercices);
        if(ejerciciosData.getRespuesta().contains("Ejercicios encontrados")) {
            System.out.println(ejerciciosData.getEjercices());
            return ResponseEntity.ok(ejerciciosData);
        }
        return ResponseEntity.status(404).body(ejerciciosData);

    }

}

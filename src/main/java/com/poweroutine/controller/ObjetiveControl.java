package com.poweroutine.controller;

import com.poweroutine.dtd.ObjetiveDTD;
import com.poweroutine.service.ObjetiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("objetive")
public class ObjetiveControl {
    private ObjetiveDTD objetiveDTD=new ObjetiveDTD();

    @Autowired
    private ObjetiveService objetiveService;

    @GetMapping("getAllObjetives")
    public ResponseEntity<ObjetiveDTD> getAllObjetives(){
        objetiveDTD = objetiveService.getAllObjetives();
        if(objetiveDTD.getRespuesta().contains("Objetivos encontrados")) {
            return ResponseEntity.ok(objetiveDTD);
        }
        return ResponseEntity.status(404).body(objetiveDTD);
    }
}

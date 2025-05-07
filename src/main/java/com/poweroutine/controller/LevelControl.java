package com.poweroutine.controller;

import com.poweroutine.dtd.LevelDTD;
import com.poweroutine.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("level")
public class LevelControl {
    private LevelDTD levelDTD=new LevelDTD();

    @Autowired
    private LevelService levelService;

    @GetMapping("getAllLevels")
    public ResponseEntity<LevelDTD> getAllLevels(){
        levelDTD=levelService.getAllLevels();
        if(levelDTD.getRespuesta().contains("Niveles encontrados")){
            System.out.println(levelDTD.getLevels());
            return ResponseEntity.ok(levelDTD);
        }
        return ResponseEntity.status(404).body(levelDTD);
    }

}

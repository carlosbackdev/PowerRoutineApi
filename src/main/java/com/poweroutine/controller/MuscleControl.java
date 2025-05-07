package com.poweroutine.controller;

import com.poweroutine.dtd.MuscleDTD;
import com.poweroutine.service.MuscleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("muscle")
public class MuscleControl {
    private MuscleDTD muscleDTD=new MuscleDTD();

    @Autowired
    private MuscleService muscleService;

    @GetMapping("getMuscles")
    public ResponseEntity<MuscleDTD> getMuscles(){
        muscleDTD = muscleService.getAllMuscles();
        if(muscleDTD.getRespuesta().contains("Musculos encontrados")) {
            System.out.println(muscleDTD.getMuscles());
            return ResponseEntity.ok(muscleDTD);
        }
        return ResponseEntity.status(404).body(muscleDTD);
    }

}

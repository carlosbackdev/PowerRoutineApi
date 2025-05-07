package com.poweroutine.service;

import com.poweroutine.dtd.MuscleDTD;
import com.poweroutine.model.MuscleModel;
import com.poweroutine.repository.MuscleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MuscleService {
    private MuscleDTD muscleDTD=new MuscleDTD();

    @Autowired
    MuscleRepository muscleRepository;

    public MuscleDTD getAllMuscles(){
        List<MuscleModel> muscles =muscleRepository.findAll();
        if(muscles.isEmpty()){
            muscleDTD.setRespuesta("No se encontraron musculos");
            return muscleDTD;
        }
        muscleDTD.setMuscles(muscles);
        muscleDTD.setRespuesta("Musculos encontrados");
        return muscleDTD;
    }

}

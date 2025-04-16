package com.poweroutine.service;

import com.poweroutine.dtd.RutineDTD;
import com.poweroutine.model.RutineModel;
import com.poweroutine.repository.RutineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RutineService {

    @Autowired
    RutineRepository rutineRepository;

    public RutineDTD getRutine(Integer dayweek) {
        RutineDTD rutineDTD = new RutineDTD(new ArrayList<>(),"Rutinas no encontradas para los dias: "+dayweek);
        System.out.println(dayweek.toString());
        List<RutineModel> rutineModelFound = rutineRepository.findByDayweekContaining(dayweek.toString());

        if(!rutineModelFound.isEmpty()) {
            rutineDTD.getRutinas().addAll(rutineModelFound);
            rutineDTD.setRespuesta("Rutinas encontradas de los dias: "+dayweek);
            return rutineDTD;
        }

        return rutineDTD;
    }

}

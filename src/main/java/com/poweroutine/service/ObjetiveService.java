package com.poweroutine.service;

import com.poweroutine.dtd.ObjetiveDTD;
import com.poweroutine.repository.ObjetiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjetiveService {
    private ObjetiveDTD objetiveDTD=new ObjetiveDTD();

    @Autowired
    private ObjetiveRepository objetiveRepository;

    public ObjetiveDTD getAllObjetives() {
        objetiveDTD.setObjetives(objetiveRepository.findAll());
        if(objetiveDTD.getObjetives().isEmpty()){
            objetiveDTD.setRespuesta("No se encontraron objetivos");
            return objetiveDTD;
        }
        objetiveDTD.setRespuesta("Objetivos encontrados");
        return objetiveDTD;
    }

}

package com.poweroutine.service;

import com.poweroutine.dtd.LevelDTD;
import com.poweroutine.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LevelService {
    private LevelDTD levelDTD=new LevelDTD();

    @Autowired
    private LevelRepository levelRepository;

    public LevelDTD getAllLevels(){
       levelDTD.setLevels(levelRepository.findAll());
       if(levelDTD.getLevels().isEmpty()){
           levelDTD.setRespuesta("No se encontraron niveles");
           return levelDTD;
       }
       levelDTD.setRespuesta("Niveles encontrados");
       return levelDTD;
    }


}

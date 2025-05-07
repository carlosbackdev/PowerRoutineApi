package com.poweroutine.service;

import com.poweroutine.dtd.BodyDTD;
import com.poweroutine.model.BodyModel;
import com.poweroutine.repository.BodyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BodyService {
    private BodyDTD bodyDTD=new BodyDTD();

    @Autowired
    private BodyRepository bodyRepository;

    public BodyModel getBodyForId(Integer id) {
        Optional<BodyModel> body = bodyRepository.findById(id);
        if (body.isPresent()) {
            return body.get();
        } else {
            return null;
        }
    }

    public BodyDTD getAllBodys(){
        List<BodyModel> bodysList= bodyRepository.findAll();
        if(bodysList.isEmpty()){
            bodyDTD.setRespuesta("No se encontraron cuerpos");
            return bodyDTD;
        }
        bodyDTD.setBodys(bodysList);
        bodyDTD.setRespuesta("cuerpos encontrados");
        return bodyDTD;
    }

}

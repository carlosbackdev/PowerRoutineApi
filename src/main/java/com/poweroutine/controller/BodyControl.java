package com.poweroutine.controller;

import com.poweroutine.dtd.BodyDTD;
import com.poweroutine.model.BodyModel;
import com.poweroutine.service.BodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("body")
public class BodyControl {

    @Autowired
    private BodyService bodyService;

    @PostMapping("getBodys")
    public ResponseEntity<BodyDTD> getBodysList(@RequestBody List<Integer> idBodys){
        BodyDTD bodyDTD = new BodyDTD();
        System.out.println(idBodys.toString());
        for(Integer id : idBodys) {
            BodyModel body = bodyService.getBodyForId(id);
            if(body != null) {
                bodyDTD.addBody(body);
            }
        }
        if(!bodyDTD.getBodys().isEmpty()){
            bodyDTD.setRespuesta("Cuerpos encontrados");
            return ResponseEntity.ok(bodyDTD);
        }
        bodyDTD.setRespuesta("No se encontraron cuerpos");
        return ResponseEntity.status(404).body(bodyDTD);
    }

}

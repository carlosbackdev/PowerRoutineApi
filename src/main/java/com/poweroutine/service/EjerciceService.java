package com.poweroutine.service;

import com.poweroutine.dtd.EjerciceDTD;
import com.poweroutine.dtd.RutineDTD;
import com.poweroutine.model.EjerciceModel;
import com.poweroutine.model.RutineModel;
import com.poweroutine.repository.EjerciceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EjerciceService {

    @Autowired
    EjerciceRepository ejerciceRepository;

    public EjerciceDTD getEjercices(List<Long> idEjercices) {
         EjerciceDTD ejerciciosData = new EjerciceDTD();
        try{
            for (Long id : idEjercices) {
                Optional<EjerciceModel> ejercicio = ejerciceRepository.findById(id);
                if (ejercicio.isPresent()) {
                    ejerciciosData.addEjercice(ejercicio.get());
                }
            }
            if(ejerciciosData.getEjercices().isEmpty()){
                ejerciciosData.setRespuesta("No se encontraron ejercicios");
                return ejerciciosData;
            }
            ejerciciosData.setRespuesta("Ejercicios encontrados");
            return ejerciciosData;
        }catch (Exception e){
            ejerciciosData.setRespuesta("Error al obtener los ejercicios");
            System.out.println("Error al obtener los ejercicios: " + e.getMessage());
        }
        return ejerciciosData;
    }

}

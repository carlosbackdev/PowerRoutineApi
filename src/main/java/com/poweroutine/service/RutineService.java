package com.poweroutine.service;

import com.poweroutine.dtd.RutineDTD;
import com.poweroutine.model.RutineModel;
import com.poweroutine.model.RutineUserModel;
import com.poweroutine.repository.RutineRepository;
import com.poweroutine.repository.RutineUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class RutineService {

    @Autowired
    RutineRepository rutineRepository;
    @Autowired
    RutineUserRepository rutineUserRepository;

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

    public String saveRutineUser(RutineDTD rutine) {
        System.out.println("rutinas:"+rutine.toString());
        if (rutine == null || rutine.getRutinas() == null || rutine.getUserModel() == null) {
            return "Datos de entrada inválidos";
        }

        try {
            List<RutineUserModel> existingRutines = rutineUserRepository.findByIdUser(rutine.getUserModel().getId());
            if (!existingRutines.isEmpty()) {
                // Eliminar rutinas existentes
                rutineUserRepository.deleteAll(existingRutines);
                System.out.println("Rutinas existentes eliminadas para el usuario: " + rutine.getUserModel().getId());
            }
            for (RutineModel rutineModel : rutine.getRutinas()) {
                RutineUserModel rutineUserModel = new RutineUserModel();
                rutineUserModel.setIdUser(rutine.getUserModel().getId());
                rutineUserModel.setRutine(rutineModel);
                System.out.println("rutina a guardar:"+rutineUserModel.toString());
                rutineUserRepository.save(rutineUserModel);
            }
            return "Rutina guardada correctamente";
        }catch (Exception e) {
            return "Error al guardar la rutina: " + e.getMessage();
        }

    }

}

package com.poweroutine.service;

import com.poweroutine.dtd.RutineDTD;
import com.poweroutine.dtd.RutineUserDTD;
import com.poweroutine.model.RutineModel;
import com.poweroutine.model.RutineUserModel;
import com.poweroutine.model.UserModel;
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

    public RutineUserDTD getRutineUser(UserModel user) {
        RutineUserDTD rutineUserDTD = new RutineUserDTD();

        try{
            List<RutineUserModel> rutineUserModelFound = rutineUserRepository.findByIdUser(user.getId());
            if(!rutineUserModelFound.isEmpty()) {
                rutineUserDTD.setRutinas(rutineUserModelFound);
                rutineUserDTD.setRespuesta("Rutinas encontradas para el usuario: " + user.getName());
                return rutineUserDTD;
            } else {
                rutineUserDTD.setRespuesta("Error: No se encontraron rutinas para el usuario: " + user.getId());
                return rutineUserDTD;
            }
        }catch (Exception e){
            rutineUserDTD.setRespuesta("Error: No se encontraron rutinas para el usuario: " + user.getId());
            return rutineUserDTD;
        }
    }

    public String rutineUserUpdate(RutineUserModel rutine) {
        if (rutine == null || rutine.getId() == null) {
            return "Error: Rutina inválida o ID no proporcionado";
        }

        try {
            Optional<RutineUserModel> existingRutine = rutineUserRepository.findById(Long.valueOf(rutine.getId()));
            if (existingRutine.isPresent()) {
                RutineUserModel rutineToUpdate = existingRutine.get();

                // Actualizar los campos necesarios
                rutineToUpdate.setName(rutine.getName());
                rutineToUpdate.setIdRutine(rutine.getIdRutine());
                rutineToUpdate.setIdUser(rutine.getIdUser());
                rutineToUpdate.setIdBody(rutine.getIdBody());
                rutineToUpdate.setIdEjercices(rutine.getIdEjercices());
                rutineToUpdate.setImage(rutine.getImage());
                rutineToUpdate.setRutineIncompatible(rutine.getRutineIncompatible());
                rutineToUpdate.setType(rutine.getType());
                rutineToUpdate.setComplement(rutine.getComplement());
                rutineToUpdate.setMuscle_principal(rutine.getMuscle_principal());
                rutineToUpdate.setDayweek(rutine.getDayweek());
                if (rutine.isCompleted()){
                    rutineToUpdate.setCompleted(rutine.isCompleted());
                }
                // Guardar los cambios
                rutineUserRepository.save(rutineToUpdate);
                return "Rutina actualizada correctamente";
            } else {
                return "Error: Rutina no encontrada con el ID proporcionado";
            }
        } catch (Exception e) {
            return "Error al actualizar la rutina: " + e.getMessage();
        }
    }
}

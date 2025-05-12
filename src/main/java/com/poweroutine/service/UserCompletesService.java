package com.poweroutine.service;

import com.poweroutine.dtd.UserCompletesDTD;
import com.poweroutine.model.UserCompletesModel;
import com.poweroutine.model.UserModel;
import com.poweroutine.repository.UserCompletesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCompletesService {
    private UserCompletesDTD userCompletesDTD = new UserCompletesDTD();

    @Autowired
    private UserCompletesRepository userCompletesRepository;

    public  UserCompletesDTD getAllCompleteByUser(UserModel user){
        List<UserCompletesModel> userCompletes= userCompletesRepository.findAllByIdUser(user.getId().intValue());
        if(userCompletes.isEmpty()){
            userCompletesDTD.setRespuesta("No se encontraron items");
            return userCompletesDTD;
        }
        userCompletesDTD.setUserCompletesModel(userCompletes);
        userCompletesDTD.setRespuesta("Items encontrados");
        return userCompletesDTD;
    }

    public boolean SaveUserCompletes(UserCompletesModel userCompletesModel){
        try {
            UserCompletesModel userCompletes=userCompletesRepository.findByIdUserAndIdItem(userCompletesModel.getIdUser(),userCompletesModel.getIdItem());
            if(userCompletes == null){
                userCompletes = new UserCompletesModel();
                userCompletes.setId(userCompletesModel.getId());
                userCompletes.setIdItem(userCompletesModel.getIdItem());
                userCompletes.setIdUser(userCompletesModel.getIdUser());
                userCompletes.setCompleted(userCompletesModel.isCompleted());
            }
            userCompletesRepository.save(userCompletes);
            return true;
        }catch (Exception e){
            System.out.println("Error al guardar la rutina: " + e.getMessage());
            return false;
        }
    }

}

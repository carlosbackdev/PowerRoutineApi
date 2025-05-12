package com.poweroutine.repository;

import com.poweroutine.model.UserCompletesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCompletesRepository extends JpaRepository<UserCompletesModel, Integer> {
    List<UserCompletesModel> findAllByIdUser(Integer idUser);
    UserCompletesModel findByIdUserAndIdItem(Integer idUser, Integer idItem);
}

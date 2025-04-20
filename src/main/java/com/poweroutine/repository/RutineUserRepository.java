package com.poweroutine.repository;


import com.poweroutine.model.RutineUserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RutineUserRepository extends JpaRepository<RutineUserModel, Long> {
    List<RutineUserModel> findByIdUser(Long idUser);
}

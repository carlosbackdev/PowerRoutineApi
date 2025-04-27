package com.poweroutine.repository;


import com.poweroutine.model.RutineUserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RutineUserRepository extends JpaRepository<RutineUserModel, Long> {
    List<RutineUserModel> findByIdUser(Long idUser);
    Optional<RutineUserModel> findByIdRutine(Long idRutine);
}

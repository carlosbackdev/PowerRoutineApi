package com.poweroutine.repository;

import com.poweroutine.model.MuscleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuscleRepository extends JpaRepository<MuscleModel, Long> {

}

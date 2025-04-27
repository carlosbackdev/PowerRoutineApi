package com.poweroutine.repository;

import com.poweroutine.model.EjerciceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EjerciceRepository extends JpaRepository<EjerciceModel, Long> {
}

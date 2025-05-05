package com.poweroutine.repository;

import com.poweroutine.model.BodyModel;
import com.poweroutine.model.EjerciceModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BodyRepository  extends JpaRepository<BodyModel, Integer> {
}

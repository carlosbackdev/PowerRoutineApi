package com.poweroutine.repository;

import com.poweroutine.model.ObjetiveModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjetiveRepository extends JpaRepository<ObjetiveModel, Long> {

}

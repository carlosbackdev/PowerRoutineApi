package com.poweroutine.repository;

import ch.qos.logback.classic.model.LevelModel;
import com.poweroutine.model.LevelRange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelRepository extends JpaRepository<LevelRange, Long> {

}

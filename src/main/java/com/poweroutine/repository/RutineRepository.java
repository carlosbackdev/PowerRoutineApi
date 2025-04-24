package com.poweroutine.repository;


import com.poweroutine.model.RutineModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RutineRepository extends JpaRepository<RutineModel, Long> {

     @Query("SELECT r FROM RutineModel r WHERE r.dayweek LIKE %:dayweek%")
     List<RutineModel> findByDayweekContaining(@Param("dayweek") String dayweek);
}

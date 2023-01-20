package com.web.repository;

import com.web.entity.PositionDoctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PositionDoctorJpaRepository extends JpaRepository<PositionDoctor,Long> {
    PositionDoctor findByPosition(String name);
    @Query("SELECT t FROM PositionDoctor t LEFT JOIN FETCH t.doctors  where t.positionDoctorId = :id")
    PositionDoctor getListDoctor(@Param("id") long id);
}

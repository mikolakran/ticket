package com.web.repository;

import com.web.entity.MedicalHistory;
import com.web.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MedicalHistoryJpaRepository extends JpaRepository<MedicalHistory,Long> {
    @Query("SELECT t FROM Passport t LEFT JOIN FETCH t.medicalHistory where t.idPassport = :id")
    Passport getListHistory(@Param("id") long id);
}

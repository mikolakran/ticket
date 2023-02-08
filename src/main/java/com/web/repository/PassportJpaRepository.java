package com.web.repository;

import com.web.entity.MedicalHistory;
import com.web.entity.Passport;
import com.web.entity.TimerTime;
import com.web.forms.TimerTimeForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface PassportJpaRepository extends JpaRepository<Passport,Long> {
    @Query("SELECT t FROM Passport t LEFT JOIN FETCH t.medicalHistory where t.idPassport = :id")
    Passport getListMedicalHistory(@Param("id") long id);
    Passport findByNameAndFamilyAndPatronymic(String name,String family,String patronymic);
    @Query("SELECT t FROM Passport t LEFT JOIN FETCH t.timerTimes where t.idPassport = :id")
    Passport findListRecord(@Param("id") long id);
}

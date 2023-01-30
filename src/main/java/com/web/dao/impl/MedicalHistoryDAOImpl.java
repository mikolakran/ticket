package com.web.dao.impl;

import com.web.dao.MedicalHistoryDAO;
import com.web.entity.Calendar;
import com.web.entity.MedicalHistory;
import com.web.exception.MyException;
import com.web.repository.MedicalHistoryJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
@Slf4j
public class MedicalHistoryDAOImpl implements MedicalHistoryDAO {

    @Autowired
    private MedicalHistoryJpaRepository medicalHistoryJpaRepository;

    @Override
    public MedicalHistory save(MedicalHistory medicalHistory) throws MyException {
        return medicalHistoryJpaRepository.save(medicalHistory);
    }

    @Override
    public MedicalHistory get(Long aLong) {
        return null;
    }

    @Override
    public void update(MedicalHistory medicalHistory) {

    }

    @Override
    public void delete(Long aLong) {

    }

}

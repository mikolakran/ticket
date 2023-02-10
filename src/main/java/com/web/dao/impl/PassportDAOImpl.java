package com.web.dao.impl;

import com.web.entity.Calendar;
import com.web.entity.MedicalHistory;
import com.web.entity.TimerTime;
import com.web.repository.PassportJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.web.dao.PassportDAO;
import com.web.entity.Passport;

import java.util.Set;

@Repository
public class PassportDAOImpl implements PassportDAO {

    @Autowired
    private PassportJpaRepository passportJpaRepository;

    @Override
    public Passport save(Passport passport) {
        return passportJpaRepository.save(passport);
    }

    @Override
    public Passport get(Long aLong) {
        return passportJpaRepository.findById(aLong).orElse(null);
    }

    @Override
    public void update(Passport passport) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Set<Calendar> getListCalendar(long idDoctor) {
        return null;
    }

    @Override
    public Set<MedicalHistory> getListHistory(long idPassport) {
        return passportJpaRepository.getListMedicalHistory(idPassport).getMedicalHistory();
    }

    @Override
    public Passport findByNameAndFamilyAndPatronymic(String name, String family, String patronymic) {
        return passportJpaRepository.findByNameAndFamilyAndPatronymic(name,family,patronymic);
    }

    @Override
    public Set<TimerTime> findListRecord(long idPassport) {
        return passportJpaRepository.findListRecord(idPassport).getTimerTimes();
    }

}

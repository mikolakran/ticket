package com.web.dao;

import com.web.entity.Calendar;
import com.web.entity.MedicalHistory;
import com.web.entity.Passport;
import com.web.entity.TimerTime;

import java.util.List;
import java.util.Set;

public interface PassportDAO extends DAO<Passport,Long>{
    Set<Calendar> getListCalendar(long idPassport);
    Set<MedicalHistory> getListHistory(long idPassport);
    Passport findByNameAndFamilyAndPatronymic(String name,String family,String patronymic);

    Set<TimerTime> findListRecord(long idPassport);
}

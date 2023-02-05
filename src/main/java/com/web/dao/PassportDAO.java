package com.web.dao;

import com.web.entity.Calendar;
import com.web.entity.MedicalHistory;
import com.web.entity.Passport;

import java.util.Set;

public interface PassportDAO extends DAO<Passport,Long>{
    Set<Calendar> getListCalendar(long idDoctor);
    Set<MedicalHistory> getListHistory(long idPassport);
    Passport findByNameAndFamilyAndPatronymic(String name,String family,String patronymic);
}

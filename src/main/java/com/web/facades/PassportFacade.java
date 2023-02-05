package com.web.facades;

import com.web.dao.PassportDAO;
import com.web.entity.Calendar;
import com.web.entity.MedicalHistory;
import com.web.entity.Passport;
import com.web.exception.MyException;
import com.web.forms.CalendarForm;
import com.web.forms.MedicalHistoryForm;
import com.web.forms.PassportForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class PassportFacade {
    @Autowired
    private PassportDAO passportDAO;

    public Passport save(Passport passport) throws MyException {
        return passportDAO.save(passport);
    }

    public PassportForm get(long idPassport) {
        Passport passport = passportDAO.get(idPassport);
        return new PassportForm(passport);
    }

    public Set<CalendarForm> getListCalendarUser(long idPassport) {
        Set<CalendarForm> calendarForms = new HashSet<>();
        Set<Calendar> calendars = passportDAO.getListCalendar(idPassport);
        calendars.forEach(calendarTicket -> {
            CalendarForm calendarForm = new CalendarForm(calendarTicket);
            calendarForms.add(calendarForm);
        });
        return calendarForms;
    }

    public Set<MedicalHistoryForm> getListHistory(long idPassport) {
        Set<MedicalHistoryForm> medicalHistories = new HashSet<>();
        Set<MedicalHistory> listHistory = passportDAO.getListHistory(idPassport);
        listHistory.forEach(medicalHistory -> {
            MedicalHistoryForm medicalHistoryForm = new MedicalHistoryForm(medicalHistory);
            medicalHistories.add(medicalHistoryForm);
        });
        return medicalHistories;
    }

    public Passport findNameAndFamilyAndPatronymic(Passport passport){
        return passportDAO.findByNameAndFamilyAndPatronymic(passport.getName(),
                passport.getFamily(), passport.getPatronymic());
    }

    private void build(Passport passport, PassportForm passportForm) {
        passport.setIdPassport(passportForm.getIdPassport());
        passport.setFamily(passportForm.getFamily());
        passport.setName(passportForm.getName());
        passport.setPatronymic(passportForm.getPatronymic());
        passport.setContactNumber(passportForm.getContactNumber());
        passport.setDateBirth(passportForm.getDateBirth());
        passport.setGender(passportForm.getGender());
        passport.setAddress(passportForm.getAddress());
    }

}

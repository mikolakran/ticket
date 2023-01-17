package com.web.facades;

import com.web.dao.PassportDAO;
import com.web.entity.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PassportFacade {
    @Autowired
    private PassportDAO passportDAO;

    public Passport save(Passport passport){
        return passportDAO.save(passport);
    }

    /*private void buildUser(Passport passport , PassportForm passportForm){
        passport.setIdPassport(passportForm.getIdPassport());
        passport.setFamily(passportForm.getFamily());
        passport.setName(passportForm.getName());
        passport.setPatronymic(passportForm.getPatronymic());
        passport.setContactNumber(passportForm.getContactNumber());
        passport.setDateBirth(passportForm.getDateBirth());
        passport.setGender(passportForm.getGender());
        passport.setAddress(passportForm.getAddress());
    }*/
}

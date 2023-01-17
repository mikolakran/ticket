package com.web.controllers;

import com.web.dao.PassportDAO;
import com.web.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TestControllers {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PassportDAO passportDAO;

    @GetMapping("/")
    public String test(){
        return "home";
    }

    @GetMapping("/addUser")
    public String test2(){
        /*User user = new User("nikolai7","1234","mikola7@mail.ru","user");
        LocalDate localDate = LocalDate.of(2001, Month.JULY,8);
        Passport passport = new Passport("SidelnicovS","NikS",
                "SergeevisS",localDate,"DobrushS");
        user.setPassport(passport);
        passport.setUser(user);
        userDAO.save(user);*/
        return "addUser";
    }
}

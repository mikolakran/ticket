package com.web.controllers;

import com.web.facades.CalendarFacade;
import com.web.facades.UserFacade;
import com.web.forms.CalendarForm;
import com.web.forms.PositionDoctorForm;
import com.web.forms.UserForm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AuthController {
    @Autowired
    private UserFacade userFacade;

    @Autowired
    private CalendarFacade calendarFacade;


    @GetMapping("/")
    public String test() {
        return "home";
    }


    @PostMapping("/loginS")
    public void getLogin(@ModelAttribute("userForm") UserForm userForm,
                         HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
        UserForm resultSQLUserForm = userFacade.getByName(userForm.getUserName());
        if (resultSQLUserForm.getPhoto() == null) {
            resultSQLUserForm.setPhoto(null);
        }
        request.getSession().setAttribute("userSession", resultSQLUserForm);
        response.sendRedirect(request.getContextPath() + "/welcome/0");
    }

    @GetMapping("/welcome/{pageNo}")
    public ModelAndView displayWelcome(@PathVariable int pageNo,
                                       @SessionAttribute UserForm userSession,
                                       @SessionAttribute(value = "positions", required = false)
                                       List<PositionDoctorForm> positions,
                                       @SessionAttribute(value = "calendars", required = false)
                                       List<CalendarForm> calendars) {
        ModelAndView modelAndView = new ModelAndView("welcome");
        modelAndView.addObject("userForm", userSession);

        if (calendars != null) {
            findFieldNameTime(userSession, calendars);
            modelAndView.addObject("calendars", calendars);
        }

        if (positions != null) {
            modelAndView.addObject(positions);
        } else {
            modelAndView.addObject("positionNull", "Position Doctor null");
            int pageSize = 15;
            int pageMinus = 0;
            if (pageNo == -1) {
                pageNo = 0;
                pageMinus = -1;
            }
            if (userSession.getDoctor() != null) {
                List<CalendarForm> calendarForms =
                        calendarFacade.findByDoctor_IdDoctor(userSession.getDoctor().getIdDoctor(), pageNo, pageSize);
                if (calendarForms.size() != 0) {
                    LocalDate currentDate = LocalDate.now();
                    List<CalendarForm> calendarDoctors = calendarForms.
                            stream().filter(calendar -> currentDate.isBefore(calendar.getLocalDate()) ||
                                    currentDate.isEqual(calendar.getLocalDate()))
                            .sorted(Comparator.comparing(CalendarForm::getLocalDate)).collect(Collectors.toList());
                    modelAndView.addObject("calendarDoctors", calendarDoctors);
                    modelAndView.addObject("idDoctor", userSession.getDoctor().getIdDoctor());
                    modelAndView.addObject("pageNo", pageNo);
                    modelAndView.addObject("pageMinus", pageMinus);
                }
            }
        }
        return modelAndView;
    }

    private void findFieldNameTime(UserForm userSession, List<CalendarForm> calendars) {
        int idPassport = (int) userSession.getPassport().getIdPassport();
        for (CalendarForm calendar : calendars) {
            Class<? extends CalendarForm> aClass = calendar.getClass();
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
                try {
                    Object o = declaredField.get(calendar);
                    if (o != null) {
                        if (o.equals(idPassport)) {
                            if (!declaredField.getName().equals("idDate")) {
                                String name = declaredField.getName();
                                name = name.replace("time", "");
                                name = name.replace("_", "-");
                                calendar.setNameTime(name);
                            }
                        }
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

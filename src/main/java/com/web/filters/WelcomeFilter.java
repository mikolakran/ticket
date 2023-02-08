package com.web.filters;


import com.web.facades.PassportFacade;
import com.web.facades.PositionDoctorFacade;
import com.web.forms.CalendarForm;
import com.web.forms.PositionDoctorForm;
import com.web.forms.TimerTimeForm;
import com.web.forms.UserForm;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Component
public class WelcomeFilter implements Filter {

    private PositionDoctorFacade positionDoctorFacade;
    private PassportFacade passportFacade;

    public WelcomeFilter(PositionDoctorFacade positionDoctorFacade, PassportFacade passportFacade) {
        this.positionDoctorFacade = positionDoctorFacade;
        this.passportFacade = passportFacade;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession(false);
        if(session != null) {
            UserForm userForm = (UserForm) session.getAttribute("userSession");
            session.removeAttribute("userAndAdmin");
            if (userForm != null) {
                if (userForm.getRole().equals("user")) {
                    LocalDate currentDate = LocalDate.now();
                    Set<TimerTimeForm> listRecordToDoctor = passportFacade
                            .findListRecordToDoctor(userForm.getPassport().getIdPassport());

                    List<TimerTimeForm> timerTimeForms = listRecordToDoctor.stream().filter(timerTimeForm ->
                            currentDate.isBefore(timerTimeForm.getCalendar().getLocalDate()) ||
                                    currentDate.isEqual(timerTimeForm.getCalendar().getLocalDate())).toList();
                    session.setAttribute("recordToDoctor",timerTimeForms);

                    List<PositionDoctorForm> positions = positionDoctorFacade.findAll();
                    if (positions.size() != 0) {
                        session.setAttribute("positions", positions);
                    } else {
                        session.removeAttribute("positions");
                    }
                }
            }
        }
        assert session != null;
        session.removeAttribute("doctor");
        filterChain.doFilter(servletRequest, servletResponse);
    }

}

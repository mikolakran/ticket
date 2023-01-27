package com.web.filters;

import com.web.facades.PositionDoctorFacade;
import com.web.forms.DoctorForm;
import com.web.forms.UserForm;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Set;

public class UserDoctorsFilter implements Filter {

    @Autowired
    private PositionDoctorFacade positionDoctorFacade;

    public UserDoctorsFilter(PositionDoctorFacade positionDoctorFacade) {
        this.positionDoctorFacade = positionDoctorFacade;
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession(false);
        UserForm userForm = (UserForm) session.getAttribute("userSession");
        if (userForm != null) {
            String idPosition = request.getParameter("idPosition");
            request.setAttribute("idPosition", idPosition);
            Set<DoctorForm> listDoctors = positionDoctorFacade.getListDoctor(Long.parseLong(idPosition));
            session.setAttribute("doctors", listDoctors);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

}

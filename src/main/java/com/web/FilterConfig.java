package com.web;

import com.web.facades.PassportFacade;
import com.web.facades.PositionDoctorFacade;
import com.web.filters.UserDoctorsFilter;
import com.web.filters.WelcomeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Autowired
    private PositionDoctorFacade positionDoctorFacade;

    @Autowired
    private PassportFacade passportFacade;


    @Bean
    public FilterRegistrationBean<WelcomeFilter> welcomeFilterFilterRegistrationBean(){
        FilterRegistrationBean<WelcomeFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new WelcomeFilter(positionDoctorFacade,passportFacade));
        filterRegistrationBean.addUrlPatterns("/welcome/0");
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<UserDoctorsFilter> postsFilterFilterRegistrationBean(){
        FilterRegistrationBean<UserDoctorsFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new UserDoctorsFilter(positionDoctorFacade));
        filterRegistrationBean.addUrlPatterns("/doctorByPosition");
        return filterRegistrationBean;
    }
}

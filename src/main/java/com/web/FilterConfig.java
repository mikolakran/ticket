package com.web;

import com.web.facades.PositionDoctorFacade;
import com.web.filters.DoctorsFilter;
import com.web.filters.WelcomeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Autowired
    private PositionDoctorFacade positionDoctorFacade;

    @Bean
    public FilterRegistrationBean<WelcomeFilter> welcomeFilterFilterRegistrationBean(){
        FilterRegistrationBean<WelcomeFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new WelcomeFilter(positionDoctorFacade));
        filterRegistrationBean.addUrlPatterns("/welcome");
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<DoctorsFilter> postsFilterFilterRegistrationBean(){
        FilterRegistrationBean<DoctorsFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new DoctorsFilter(positionDoctorFacade));
        filterRegistrationBean.addUrlPatterns("/doctors");
        return filterRegistrationBean;
    }
}

package com.web;

import com.web.authentication.MyDBAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    private MyDBAuthenticationService myDBAuthenticationService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myDBAuthenticationService);

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .securityMatcher("/", "/login", "/addUser",
                        "/welcome/**",
                        "users/**","passports/**","/doctors/**","/calendars/**","/admin/**","/user/**","/positionDoctors/**",
                        "/medicalHistory/**","/allUsers",/*"/addMedicalHistory/**",*/
                        "/calendarForUser/**","/confirmTime","/doctorByPosition","/time")
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers("/", "/login", "/addUser").permitAll()
                                .requestMatchers("/welcome/**").hasAnyRole("ADMIN", "USER", "DOCTOR")
                                .requestMatchers( "users/**","passports/**","/doctors/**","/calendars/**",
                                        "/admin/**").hasRole("ADMIN")
                                .requestMatchers("/medicalHistory","/allUsers","/addMedicalHistory/**")
                                .hasRole("DOCTOR")
                                .requestMatchers("/calendarForUser/**","/confirmTime",
                                        "/doctorByPosition/**","/time")
                                .hasRole("USER")
                                .anyRequest().authenticated())
                .formLogin()
                .usernameParameter("userName")
                .successForwardUrl("/loginS")
                .permitAll();
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().requestMatchers("/static/css/**", "/js/**", "/lib/**", "/favicon.ico");
    }
}

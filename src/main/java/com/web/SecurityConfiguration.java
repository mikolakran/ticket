package com.web;

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
import com.web.authentication.MyDBAuthenticationService;

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
                        "/welcome"/*, "/users", "/upDateUser", "/addPositionDoctor/**"
                ,"/addDoctor","/doctors/**","/displayAllUsers","/confirmTimeUser","/doctorByPosition"*/)
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers("/", "/login", "/addUser").permitAll()
                                .requestMatchers("/welcome").hasAnyRole("ADMIN", "USER","DOCTOR")
                                .requestMatchers("/users/**","/doctors/**","/addPositionDoctor","/addDoctor").hasRole("ADMIN")
                                .requestMatchers("/displayAllUsers").hasRole("DOCTOR")
                                .requestMatchers("/doctorByPosition/**").hasRole("USER")
                                .requestMatchers("/confirmTimeUser").hasRole("USER")
                                .requestMatchers("/addPost/**").hasRole("USER")
                                .requestMatchers("/updatePost/**").hasRole("USER")
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

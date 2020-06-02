package com.placesearch.security;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Log
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   @Autowired
   LoginUserService loginUserService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        log.info("security config.........");

        //Authority Page
        http.authorizeRequests().antMatchers("/guest/**").permitAll();

        http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
        http.authorizeRequests().antMatchers("/").hasRole("ADMIN");

        //h2-console Connect
        http.csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("!/h2-console/**"));
        http.headers().frameOptions().disable();

        //Custom Login Page
        http.formLogin().loginPage("/login");

        //Repository Login
        //http.userDetailsService(loginUserService);

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{

        log.info("build Auth global..........");

        auth.userDetailsService(loginUserService).passwordEncoder(passwordEncoder());

    }

}

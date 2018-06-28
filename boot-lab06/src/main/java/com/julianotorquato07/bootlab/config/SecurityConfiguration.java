package com.julianotorquato07.bootlab.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{


    @Bean public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/foo/**").hasAnyRole("USER")
//                .antMatchers("/bar/**").hasAnyRole("MANAGER")
//                .anyRequest().fullyAuthenticated()
//                .and().httpBasic().and().csrf().disable();
//    }
//
////
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("aluno").password("$2a$04$nHWWphlvvSWTIPp7hXzE6OmCl8FrLI4sDhski9lAocHvUBPuAT.2y").roles("USER");
        auth.inMemoryAuthentication()
                .withUser("professor").password("$2a$04$nHWWphlvvSWTIPp7hXzE6OmCl8FrLI4sDhski9lAocHvUBPuAT.2y").roles("MANAGER");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/alunos/**").hasAnyRole("USER")
                .antMatchers("/api/disciplinas/**").hasAnyRole("MANAGER")
                .anyRequest().fullyAuthenticated()
                .and().httpBasic().and().csrf().disable();
    }
}

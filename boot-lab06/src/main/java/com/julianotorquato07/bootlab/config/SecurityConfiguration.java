package com.julianotorquato07.bootlab.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{


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
                .withUser("barry").password("(noop)torquato").roles("USER");
    }
}

package com.example.demo.security;

import org.springframework.context.annotation.Configuration;
        import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
public class Login extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("waiter")
                .password("{noop}aman")
                .roles("WAITER")
                .and()
                .withUser("manager")
                .password("{noop}aman")
                .roles("MANAGER")
                .and()
                .withUser("aman")
                .password("{noop}aman")
                .roles("OWNER");

    }
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                .antMatchers("/getDishes")
                 .hasAnyRole("WAITER","MANAGER","OWNER")
                .antMatchers("/owner")
                .hasRole("OWNER")
                .antMatchers("/manager")
                .hasAnyRole("MANAGER","OWNER")
                .antMatchers("/waiter")
                .hasAnyRole("WAITER","MANAGER","OWNER")
                .and()
                .formLogin();
    }
}
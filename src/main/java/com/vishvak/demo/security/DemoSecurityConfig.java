package com.vishvak.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .authorizeHttpRequests(
                        configurer ->
                                configurer
                                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
                );


        // Here we are configuring the application to use  HTTP Basic Authentication which means that the client will need to provide
        // username and password for accessing the endpoints.
        httpSecurity.httpBasic(Customizer.withDefaults());

        // We are disabling CSRF Cross-Site Request Forgery. This is often done during development and removed when in production.
        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }
}

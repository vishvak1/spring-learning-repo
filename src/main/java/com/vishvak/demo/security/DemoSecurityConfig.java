package com.vishvak.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    // This type of configuring security for your Spring application is called Programmatic Security.
    // Gives a more fine-grained control over security logic.Programmatic security is suitable
    // when you need highly customized security logic that cannot be easily expressed through annotations or declarative means.

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john = User.builder().username("john").password("{noop}test123").roles("EMPLOYEE").build();
        // The above line of code is using the Builder pattern.

        UserDetails mary = User.builder().username("mary").password("{noop}test123").roles("EMPLOYEE", "MANAGER").build();

        UserDetails susan = User.builder().username("susan").password("{noop}test123").roles("EMPLOYEE", "MANAGER", "ADMIN").build();

        return new InMemoryUserDetailsManager(john, mary, susan);
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

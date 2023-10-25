package com.vishvak.demo.config;

import com.vishvak.demo.service.DemoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfig {

    @Bean
    public DemoService demoService(){
        return new DemoService();
    }
}

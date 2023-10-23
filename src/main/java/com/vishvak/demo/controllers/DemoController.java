package com.vishvak.demo.controllers;

import com.vishvak.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    private DemoService demoService1;

    @Autowired
    private DemoService demoService2;

    @GetMapping("/counter")
    public int getCounter() {
        demoService2.incrementCounter();
        return demoService1.getCounter();
    }
}
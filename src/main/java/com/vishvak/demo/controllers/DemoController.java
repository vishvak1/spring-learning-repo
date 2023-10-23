package com.vishvak.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/hello")
    public String getHelloWorld(){
        return "<h1>Hello World!</h1>";
    }
}

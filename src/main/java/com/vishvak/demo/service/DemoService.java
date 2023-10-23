package com.vishvak.demo.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton") // Change this to "prototype" and try running it
public class DemoService {

    private int counter = 0;

    public int incrementCounter() {
        return ++counter;
    }

    public int getCounter() {
        return counter;
    }
}
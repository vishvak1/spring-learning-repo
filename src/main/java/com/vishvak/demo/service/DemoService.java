package com.vishvak.demo.service;

public class DemoService {

    private int counter = 0;

    public int incrementCounter() {
        return ++counter;
    }

    public int getCounter() {
        return counter;
    }
}
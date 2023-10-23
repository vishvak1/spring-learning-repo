package com.vishvak.demo.service.impl;

import com.vishvak.demo.service.Coach;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("Cricket coach Initialized");
    }

    @Override
    public String giveInstructionsFromTheSidelines() {
        return "GO For a HOME-RUN!!!";
    }
}

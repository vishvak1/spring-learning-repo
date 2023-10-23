package com.vishvak.demo.service.impl;

import com.vishvak.demo.service.Coach;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

    public TrackCoach(){
        System.out.println("Track coach Initialized");
    }

    @Override
    public String giveInstructionsFromTheSidelines() {
        return "3,2,1 GO!!!";
    }
}

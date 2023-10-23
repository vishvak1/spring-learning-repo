package com.vishvak.demo.service.impl;

import com.vishvak.demo.service.Coach;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BaseballCoach implements Coach {
    public BaseballCoach() {
        System.out.println("Baseball coach Initialized");
    }

    @Override
    public String giveInstructionsFromTheSidelines() {
        return "GO For a HOME-RUN!!!";
    }
}

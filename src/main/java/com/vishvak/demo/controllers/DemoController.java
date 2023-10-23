package com.vishvak.demo.controllers;

import com.vishvak.demo.service.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coach")
public class DemoController {

    @Autowired
    private Coach coach; //FieldSetting: Not recommended

    @GetMapping("/sidelines")
    public String getCoachInstructions(){
        return coach.giveInstructionsFromTheSidelines();
    }
}

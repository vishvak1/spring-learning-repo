package com.vishvak.demo.controllers;

import com.vishvak.demo.config.BannerMapConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/banner")
public class DemoController {

    @Autowired
    private BannerMapConfig bannerConfigMap;

    @GetMapping("/map")
    public Map<String, String> getHelloWorld(){
        return bannerConfigMap.getBannerMapConfig();
    }
}

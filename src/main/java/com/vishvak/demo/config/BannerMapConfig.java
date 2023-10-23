package com.vishvak.demo.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import java.util.Map;

@Configuration
@ConfigurationProperties(value = "app-config")
public class BannerMapConfig {

    @Value("${app-config.banner-config-map}")
    String bannerConfigMap;

    private Map<String, String> bannerConfig;

    TypeReference<Map<String, String>> type = new TypeReference<>() {};

    @PostConstruct
    public void init() {
        try {
            // Convert the property value to a Map<String, String>
            ObjectMapper objectMapper = new ObjectMapper();
            bannerConfig = objectMapper.readValue(bannerConfigMap, type);
        } catch (Exception e) {
            // Handle the exception
            throw new RuntimeException("Error converting property value to Map<String, String>", e);
        }
    }

    public Map<String, String> getBannerMapConfig() {
        return bannerConfig;
    }

}


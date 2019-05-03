package com.tqsHW1.WeatherProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WeatherProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherProjectApplication.class, args);
    }

}

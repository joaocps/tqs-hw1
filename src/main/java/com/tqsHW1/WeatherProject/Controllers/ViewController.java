/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tqsHW1.WeatherProject.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author jcps
 */

@RestController
@RequestMapping(path = "/")
public class ViewController {
    
    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/";
    private static final String END_URL = "&units=metric";
    private static final String MY_KEY = "f15d322fc88c404f0560bf7423da5a98";
    //Payed option
    private static final String BEFOREDAYS = "&cnt=";

    private String index = "index";

    @GetMapping(value = "index")
    public String returnIndex() {
        return index;
    }
        
    @PostMapping(path = "dayweather")
    public @ResponseBody Object getDayWeather(@RequestParam("local") String local) {

        RestTemplate restTemplate = new RestTemplate();
        //HttpHeaders headers = new HttpHeaders();
        
        try{
            ResponseEntity<Object> oneday = restTemplate.
                getForEntity(WEATHER_URL + "weather" + "?q=" + local + "&appid=" + MY_KEY + END_URL,
                Object.class);
            return oneday;
        } catch(HttpStatusCodeException exception) {
            return ResponseEntity.status(exception.getRawStatusCode()).headers(exception.getResponseHeaders())
                .body(exception.getResponseBodyAsString());
        }   
    }
    
    @PostMapping(path = "weekweather")
    public @ResponseBody Object getWeekWeather(@RequestParam("local") String local) {

        RestTemplate restTemplate = new RestTemplate();
        //HttpHeaders headers = new HttpHeaders();

        try{
            ResponseEntity<Object> week = restTemplate.
                getForEntity(WEATHER_URL + "forecast" + "?q=" + local + "&appid=" + MY_KEY + END_URL,
                Object.class);
            return week;
        }catch(HttpStatusCodeException exception) {
            return ResponseEntity.status(exception.getRawStatusCode()).headers(exception.getResponseHeaders())
                .body(exception.getResponseBodyAsString());
        }

    }
    
}

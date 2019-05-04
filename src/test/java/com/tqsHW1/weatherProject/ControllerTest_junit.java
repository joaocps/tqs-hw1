/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tqsHW1.weatherProject;

import com.tqsHW1.weatherProject.controllers.ViewController;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.runner.RunWith;



/**
 *
 * @author jcps
 */

public class ControllerTest_junit {
    
    private ViewController viewController = new ViewController();
    private String locality = "Porto";
    
    @Before
    public void setup(){
    }
    
    @Test
    public void testControllerCreation(){
        System.out.println("TEST CREATION");
        assertNotNull(viewController);
    }
    @Test
    public void testViewControllerIndex() {
        System.out.println("TEST INDEX");
        String result = viewController.returnIndex();
        assertEquals("index", result);
    }
    
    @Test
    public void testLocalityCurrentWeatherAvalible(){
        System.out.println("TEST LOCALITY WEATHER");
        Object res = viewController.getDayWeather(locality);
        Object res2 = viewController.getDayWeather("Lisboa");
        assertThat(res, not(res2));        
    }
    
    @Test
    public void testLocalityCurrentWeatherNotValidCity(){
        System.out.println("TEST NOT VALID CITY");
        Object notvalid = viewController.getDayWeather("adnsoaw");
        System.out.println(notvalid);
        // HOW CAN I ACCESS OBJECT VALUES ??
    }
    

}

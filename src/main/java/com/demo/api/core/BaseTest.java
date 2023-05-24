package com.demo.api.core;

import com.demo.api.dto.request.LoginRequest;
import com.demo.api.pageobject.ResgristerPage;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeMethod;


import static com.demo.api.utils.LoadConfig.LOAD_CONFIG;

public class BaseTest {
    public static String token;
    public BaseTest(){

    }

    @BeforeMethod
    public void setUp(){
        RestAssured.baseURI = LOAD_CONFIG.getProperty("domain");
        String email = LOAD_CONFIG.getProperty("email");
        String password = LOAD_CONFIG.getProperty("password");
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(email);
        loginRequest.setPassword(password);
        token =  new ResgristerPage().getTokenLogin(loginRequest);
    }

}

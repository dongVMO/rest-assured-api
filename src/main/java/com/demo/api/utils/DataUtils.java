package com.demo.api.utils;

import com.github.javafaker.Faker;

public class DataUtils {
    private Faker faker;
    public static  DataUtils getData(){
        return  new DataUtils();
    }
    private  DataUtils(){
        faker = new Faker();
    }

    public String getFirstName(){
        return faker.name().firstName();
    }
    public String getLocation(){
        return faker.address().city();
    }
    public String getEmail(){
        return faker.internet().emailAddress();
    }
    public int getPassword(){
        return faker.number().numberBetween(100000, 999999);
    }


}

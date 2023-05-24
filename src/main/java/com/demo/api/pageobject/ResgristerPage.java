package com.demo.api.pageobject;

import com.demo.api.dto.request.LoginRequest;
import com.demo.api.dto.request.ResgristerRequestObject;
import com.demo.api.dto.response.regrister.ResgristerResponseData;
import com.demo.api.dto.response.regrister.ResgristerResponseObject;
import com.demo.api.services.ResgristerService;

public class ResgristerPage {
    ResgristerService resgristerService;
    public ResgristerPage(){
        resgristerService = new ResgristerService();
    }

    public String getToken(ResgristerRequestObject resgristerRequestObject){
        ResgristerResponseObject resgristerResponse= resgristerService.postResgrister(resgristerRequestObject);
        ResgristerResponseData resgristerResponseData = resgristerResponse.getData();
        return resgristerResponseData.getToken();
    }
    public String getTokenLogin(LoginRequest loginRequest){
        ResgristerResponseObject resgristerResponse= resgristerService.postLogin(loginRequest);
        ResgristerResponseData resgristerResponseData = resgristerResponse.getData();
        return resgristerResponseData.getToken();
    }

}

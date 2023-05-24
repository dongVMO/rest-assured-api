package com.demo.api.services;

import com.demo.api.constants.Endpoints;
import com.demo.api.core.BaseApi;
import com.demo.api.dto.request.LoginRequest;
import com.demo.api.dto.request.ResgristerRequestObject;
import com.demo.api.dto.response.GetUserResponse;
import com.demo.api.dto.response.regrister.ResgristerResponseObject;
import com.demo.api.utils.ObjectMapperUtils;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class ResgristerService extends BaseApi {
    protected  Response response;

    public  ResgristerResponseObject postResgrister (ResgristerRequestObject resgristerRequestObject){
        RequestSpecification spec = getRequestBuilderWithoutToken(Endpoints.RESGRISTER_PATH)
                .body(ObjectMapperUtils.convertDTOClassToJSONStringGson(resgristerRequestObject));

        response = this.dispatchServiceRequest(spec, Method.POST);
        return ObjectMapperUtils.convertJSONStringToDTOClassByGson(response.body().asString(),ResgristerResponseObject.class);
    }

    public  ResgristerResponseObject postLogin(LoginRequest loginRequest){
        RequestSpecification spec = getRequestBuilderWithoutToken(Endpoints.LOGIN_PATH)
                .body(ObjectMapperUtils.convertDTOClassToJSONStringGson(loginRequest));

        response = this.dispatchServiceRequest(spec, Method.POST);
        return ObjectMapperUtils.convertJSONStringToDTOClassByGson(response.body().asString(),ResgristerResponseObject.class);
    }

    public GetUserResponse getAllUser(String token) {
        RequestSpecification spec = getRequestBuilderWithToken(Endpoints.GET_USER_PATH, token);
        response = this.dispatchServiceRequest(spec, Method.GET);
        return ObjectMapperUtils.convertJSONStringToDTOClassByGson(response.body().asString(), GetUserResponse.class);
    }
}

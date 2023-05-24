package com.demo.api.services;

import com.demo.api.apipath.Endpoints;
import com.demo.api.core.BaseApi;
import com.demo.api.dto.request.CreateUserRequest;
import com.demo.api.dto.request.LoginRequest;
import com.demo.api.dto.request.ResgristerRequestObject;
import com.demo.api.dto.response.CreateUserResponse;
import com.demo.api.dto.response.GetUserResponse;
import com.demo.api.dto.response.regrister.ResgristerResponseObject;
import com.demo.api.utils.ObjectMapperUtils;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;


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
    public CreateUserResponse createUser(CreateUserRequest createUserRequest, String token) {
        RequestSpecification spec = getRequestBuilderWithToken(Endpoints.USER_PATH,token)
            .body(ObjectMapperUtils.convertDTOClassToJSONStringGson(createUserRequest));
        response= this.dispatchServiceRequest(spec, Method.POST);
        return ObjectMapperUtils.convertJSONStringToDTOClassByGson(response.body().asString(),CreateUserResponse.class);
    }

    public GetUserResponse getUserWithID(String token, int id) {
        System.out.println("Url: " + Endpoints.GET_USER_PATH + "/" + id);
        RequestSpecification spec = getRequestBuilderWithToken(Endpoints.USER_PATH + "/" + id, token);
        response = this.dispatchServiceRequest(spec, Method.GET);
        return ObjectMapperUtils.convertJSONStringToDTOClassByGson(response.body().asString(), GetUserResponse.class);
    }
    public ResgristerService deleteUserWithID(String token, int id) {
        System.out.println("Url: " + Endpoints.GET_USER_PATH + "/" + id);
        RequestSpecification spec = getRequestBuilderWithToken(Endpoints.USER_PATH + "/" + id, token);
        response = this.dispatchServiceRequest(spec, Method.DELETE);
        response.prettyPrint();
        return this;
    }
    public ResgristerService validateStatusCode(int statusCode){
        int code = response.getStatusCode();
        Assert.assertEquals(code,statusCode);
        return this;
    }
    public ResgristerService verifyDataInResponse(String jsonLocator, String value) {
        JsonPath jsonPathEvaluator = response.jsonPath();
        Assert.assertEquals(jsonPathEvaluator.get(jsonLocator), value, "Correct "+ jsonLocator + " received in the Response");
        return this;
    }
    public int getID(){
        JsonPath jsonPathEvaluator = response.jsonPath();
        int id = jsonPathEvaluator.get("id");
        return id;
    }
}

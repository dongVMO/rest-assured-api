package com.demo.api.services;

import com.demo.api.constants.Endpoints;
import com.demo.api.core.BaseApi;
import com.demo.api.dto.request.CreateUserRequestObject;
import com.demo.api.dto.response.CreateUserResponse;
import com.demo.api.dto.response.GetUserResponse;
import com.demo.api.utils.ObjectMapperUtils;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class CreateUserService extends BaseApi {
    protected Response response;

    public CreateUserResponse createUser(CreateUserRequestObject createUserRequest, String token) {
        RequestSpecification spec = getRequestBuilderWithToken(Endpoints.USER_PATH, token)
                .body(ObjectMapperUtils.convertDTOClassToJSONStringGson(createUserRequest));
        response = this.dispatchServiceRequest(spec, Method.POST);
        return ObjectMapperUtils.convertJSONStringToDTOClassByGson(response.body().asString(), CreateUserResponse.class);
    }

    public GetUserResponse getUserWithID(String token, int id) {
        RequestSpecification spec = getRequestBuilderWithToken(Endpoints.USER_PATH + "/" + id, token);
        response = this.dispatchServiceRequest(spec, Method.GET);
        return ObjectMapperUtils.convertJSONStringToDTOClassByGson(response.body().asString(), GetUserResponse.class);
    }

    public CreateUserService deleteUserWithID(String token, int id) {
        RequestSpecification spec = getRequestBuilderWithToken(Endpoints.USER_PATH + "/" + id, token);
        response = this.dispatchServiceRequest(spec, Method.DELETE);
        response.prettyPrint();
        return this;
    }

    public CreateUserService validateStatusCode(int statusCode) {
        int code = response.getStatusCode();
        Assert.assertEquals(code, statusCode);
        return this;
    }

    public CreateUserService verifyDataInResponse(String jsonLocator, String value) {
        JsonPath jsonPathEvaluator = response.jsonPath();
        Assert.assertEquals(jsonPathEvaluator.get(jsonLocator), value, "Correct " + jsonLocator + " received in the Response");
        return this;
    }
    public CreateUserService verifyDataInResponse(String jsonLocator, Integer demo) {
        JsonPath jsonPathEvaluator = response.jsonPath();
        Assert.assertEquals(jsonPathEvaluator.get(jsonLocator), demo, "Correct " + jsonLocator + " received in the Response");
        return this;
    }

    public int getID() {
        JsonPath jsonPathEvaluator = response.jsonPath();
        int id = jsonPathEvaluator.get("id");
        return id;
    }
}

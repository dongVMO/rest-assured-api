package com.demo.api.core;

import com.demo.api.exception.TestContextException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class BaseApi {
    private static ThreadLocal<Response> response = new ThreadLocal();
    private Map<String, String> cookies = new HashMap<String, String>();
    private Map<String, String> headers = new HashMap<String, String>();

    protected RequestSpecification getRequestBuilderWithoutToken(String apiPath) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .basePath(apiPath)
                .log().all();
    }

    protected RequestSpecification getRequestBuilderWithToken(String apiPath, String token) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .header("Authorization","Bearer "+ token)
                .basePath(apiPath)
                .log().all();

    }
    public Response dispatchServiceRequest(RequestSpecification request, Method method) {
        switch (method) {
            case POST:
                return request.post().thenReturn();
            case PUT:
                return request.put().thenReturn();
            case GET:
                return request.get().thenReturn();
            case DELETE:
                return request.delete().thenReturn();
            case HEAD:
                return request.head().thenReturn();
            case OPTIONS:
                return request.options().thenReturn();
            case PATCH:
                return request.patch().thenReturn();
            default:
                throw new TestContextException(
                        String.format("Not Support Request Method %s", method.name()));
        }
    }
    public Response getResponse() {
        return (Response)response.get();
    }

    public Map<String, String> getCookies() {
        return cookies;
    }

    public void setCookies(Map<String, String> cookies) {
        this.cookies = cookies;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
    public BaseApi validateStatusCode(int statusCode) {
       int code = getResponse().statusCode();
        Assert.assertEquals(code,statusCode);
        return this;
    }
}

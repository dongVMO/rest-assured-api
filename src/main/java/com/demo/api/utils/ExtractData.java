package com.demo.api.utils;

import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;

import java.util.List;

public class ExtractData {

    public static <T> List<T> dataInResponse(Response response, String field) {
        return JsonPath.parse(response.asString()).read(String.format("$..%s", field));
    }

}

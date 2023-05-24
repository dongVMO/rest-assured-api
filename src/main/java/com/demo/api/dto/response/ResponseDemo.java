package com.demo.api.dto.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResponseDemo {
    //ID, id , Id
    @JsonAlias({"id", "Id", "ID"})
    @JsonProperty("user_name")
    private int id;
    @JsonProperty("user_name")
    private String username;
}

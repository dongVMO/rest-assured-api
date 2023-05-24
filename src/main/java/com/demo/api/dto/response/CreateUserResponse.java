package com.demo.api.dto.response;

import lombok.Data;


@Data
public class CreateUserResponse {
    public String name;
    public String email;
    public String location;
}

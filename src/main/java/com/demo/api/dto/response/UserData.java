package com.demo.api.dto.response;

import lombok.Data;

@Data
public class UserData {
    public int id;
    public String name;
    public String email;
    public String profilepicture;
    public String location;
    public String createdat;
}

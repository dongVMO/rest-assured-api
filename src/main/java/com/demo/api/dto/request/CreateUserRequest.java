package com.demo.api.dto.request;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
    @SerializedName("email")
    private String email;
    @SerializedName("name")
    private String name;
    @SerializedName("location")
    private String location;
}

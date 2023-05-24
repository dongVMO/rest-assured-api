package com.demo.api.dto.response.regrister;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResgristerResponseData {
    @SerializedName("Id")
    public int id;
    @SerializedName("Name")
    public String name;
    @SerializedName("Email")
    public String email;
    @SerializedName("Token")
    public String token;
}

package com.demo.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResgristerRequestObject {
    public String name;
    public String email;
    public int password;

}

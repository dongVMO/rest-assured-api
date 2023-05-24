package com.demo.api.dto.response;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class GetUserResponse {
    public int page;
    @SerializedName("per_page")
    public int perPage;
    @SerializedName("totalrecord")
    public int totalRecord;
    @SerializedName("total_pages")
    public int totalPages;
    public List<UserData> data;
}


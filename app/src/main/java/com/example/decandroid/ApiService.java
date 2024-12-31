package com.example.decandroid;

import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @POST("login/v2/getOtp")
    Call<ResponseModel> createUser(@Body JsonObject user);

    @GET("orgs/octokit/repos")
    Call<List<Repository>> getList();
}

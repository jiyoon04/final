package com.example.finalproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("/api_root/Post/")
    Call<List<Post>> getPost();
}

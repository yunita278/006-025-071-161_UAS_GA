package com.example.a006025071161_uasga.api;

import com.example.a006025071161_uasga.model.ListLocationModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("JsonDisplayMarker.php")
    Call<ListLocationModel> getAllLocation();
}

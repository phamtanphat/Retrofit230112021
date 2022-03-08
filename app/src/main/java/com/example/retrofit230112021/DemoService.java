package com.example.retrofit230112021;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DemoService{

    @GET("KhoaPhamTraining/json/tien/demo1.json")
    Call<Demo1> fetchDemo1();

    @GET("KhoaPhamTraining/json/tien/demo2.json")
    Call<Demo2> fetchDemo2();
}

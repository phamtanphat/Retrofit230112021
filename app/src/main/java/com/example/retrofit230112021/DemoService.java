package com.example.retrofit230112021;

import com.example.retrofit230112021.demo1.Demo1;
import com.example.retrofit230112021.demo2.Demo2;
import com.example.retrofit230112021.demo3.Demo3;
import com.example.retrofit230112021.demo5.Demo5;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

public interface DemoService{

    @GET("KhoaPhamTraining/json/tien/demo1.json")
    Call<Demo1> fetchDemo1();

    @GET("KhoaPhamTraining/json/tien/demo2.json")
    Call<Demo2> fetchDemo2();

    @GET("KhoaPhamTraining/json/tien/demo3.json")
    Call<Demo3> fetchDemo3();

    @GET("KhoaPhamTraining/json/tien/demo5.json")
    Call<List<Demo5>> fetchDemo5();
}

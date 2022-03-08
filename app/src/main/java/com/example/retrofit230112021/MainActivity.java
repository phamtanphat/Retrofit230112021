package com.example.retrofit230112021;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    DemoService demoService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //https://khoapham.vn/KhoaPhamTraining/json/tien/demo1.json

        // production
        // develop

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(interceptor)
                .protocols(Arrays.asList(Protocol.HTTP_1_1))
                .build();

        Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://khoapham.vn/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        demoService = retrofit.create(DemoService.class);



        callDemo2();
    }

    private void callDemo1(){
        Call<Demo1> callApi1 = demoService.fetchDemo1();

        callApi1.enqueue(new Callback<Demo1>() {
            @Override
            public void onResponse(Call<Demo1> call, Response<Demo1> response) {
                if (response.errorBody() != null){
                    try {
                        Log.d("BBB",response.errorBody().string());
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                Demo1 demo1 = response.body();
                Log.d("BBB",demo1.toString());
            }

            @Override
            public void onFailure(Call<Demo1> call, Throwable t) {
                Log.d("BBB", t.getMessage());
            }
        });
    }

    private void callDemo2(){
        Call<Demo2> callApi2 = demoService.fetchDemo2();

        callApi2.enqueue(new Callback<Demo2>() {
            @Override
            public void onResponse(Call<Demo2> call, Response<Demo2> response) {
                if (response.errorBody() != null){
                    try {
                        Log.d("BBB",response.errorBody().string());
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                Demo2 demo2 = response.body();
                Log.d("BBB",demo2.toString());
            }

            @Override
            public void onFailure(Call<Demo2> call, Throwable t) {
                Log.d("BBB", t.getMessage());
            }
        });
    }
}
package com.example.retrofit230112021;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.example.retrofit230112021.demo1.Demo1;
import com.example.retrofit230112021.demo2.Demo2;
import com.example.retrofit230112021.demo3.Demo3;
import com.example.retrofit230112021.demo5.Demo5;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

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



        callDemo5();
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

    private void callDemo3(){
        Call<Demo3> callApi3 = demoService.fetchDemo3();

        callApi3.enqueue(new Callback<Demo3>() {
            @Override
            public void onResponse(Call<Demo3> call, Response<Demo3> response) {
                if (response.errorBody() != null){
                    try {
                        Log.d("BBB",response.errorBody().string());
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                Demo3 demo3 = response.body();
                Log.d("BBB",demo3.toString());
            }

            @Override
            public void onFailure(Call<Demo3> call, Throwable t) {
                Log.d("BBB", t.getMessage());
            }
        });
    }

    private void callDemo5(){
        Call<List<Demo5>> callApi5 = demoService.fetchDemo5();

        callApi5.enqueue(new Callback<List<Demo5>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<Demo5>> call, Response<List<Demo5>> response) {
                if (response.errorBody() != null){
                    try {
                        Log.d("BBB",response.errorBody().string());
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                List<Demo5> demo5 = response.body();
                demo5.forEach(new Consumer<Demo5>() {
                    @Override
                    public void accept(Demo5 demo5) {
                        Log.d("BBB",demo5.toString());
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Demo5>> call, Throwable t) {
                Log.d("BBB", t.getMessage());
            }
        });
    }
}
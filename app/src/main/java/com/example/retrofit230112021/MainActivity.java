package com.example.retrofit230112021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //https://khoapham.vn/KhoaPhamTraining/json/tien/demo1.json

        // production
        // develop

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL);
    }
}
package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    static final String BASE_URL = "http://10.0.2.2:8080/dsaApp/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Poner el codigo que crea el retrofit
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        System.out.println("111111!!!!");

        TracksAPI tracksAPI = retrofit.create(TracksAPI.class);

        //Hago una llamada a la funcion de retrofit findAllTracks
        Call<List<Track>> call = tracksAPI.findAllTracks();
        call.enqueue(new Callback<List<Track>>() {
            @Override
            public void onResponse(Call<List<Track>> call, Response<List<Track>> response) {

            }

            @Override
            public void onFailure(Call<List<Track>> call, Throwable t) {

            }
        });

        // la llamada tiene 2 callbacks --> en el o



    }
}
package com.akijtakafullife.retrofit_prac_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit=new Retrofit
                .Builder()
                .baseUrl("https://cricket.sportmonks.com/api/v2.0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OurRetrofitClient ourRetrofitClient=retrofit.create(OurRetrofitClient.class);
        Call<MainDataClass> call= ourRetrofitClient.getData("W3hltpCIPZGec3wQHwUSDrWosNKS52xGq8W9SFSrELbp5CiI3W1392ls86I9");

        call.enqueue(new Callback<MainDataClass>() {
            @Override
            public void onResponse(Call<MainDataClass> call, Response<MainDataClass> response) {
                if (response.isSuccessful()){
                    List<ObjectDataClass> list= response.body().getData();
                    for (ObjectDataClass objectDataClass:list){
                        Log.d("id", String.valueOf(objectDataClass.getId()));
                        Log.d("name", String.valueOf(objectDataClass.getName()));
                        Log.d("resource", String.valueOf(objectDataClass.getResource()));
                        Log.d("updated_at", String.valueOf(objectDataClass.getUpdated_at()));
                    }
                }
                else {
                    Log.d("response", "onFailure: fail");
                }
            }

            @Override
            public void onFailure(Call<MainDataClass> call, Throwable t) {
                Log.d("response", "onFailure: fail");
            }
        });
    }
}
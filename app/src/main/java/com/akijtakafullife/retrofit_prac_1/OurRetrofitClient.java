package com.akijtakafullife.retrofit_prac_1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OurRetrofitClient {

    @GET("continents")
    Call<MainDataClass> getData(@Query("api_token") String token);
}

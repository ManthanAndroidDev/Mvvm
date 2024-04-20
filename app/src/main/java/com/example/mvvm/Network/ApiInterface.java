package com.example.mvvm.Network;


import android.telecom.Call;

import com.example.mvvm.Model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("everything?q=tesla&from=2023-05-21&sortBy=publishedAt")
    Call<NewsResponse> newResponse(@Query("apiKey")String apiKey);

}

package com.example.jessi.mvptest.data.network.retrofit;

import com.example.jessi.mvptest.BuildConfig;
import com.example.jessi.mvptest.data.models.simpsonmodels.Simpsons;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
//    @GET("?q=simpsons+characters&format=json")
//    Call<Simpsons> getRelatedTopics();

    @GET(BuildConfig.SERVER_URL_XFIN)
    Call<Simpsons> getRelatedTopics();
}

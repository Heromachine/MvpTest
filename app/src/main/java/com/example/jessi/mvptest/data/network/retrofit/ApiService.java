package com.example.jessi.mvptest.data.network.retrofit;

import com.example.jessi.mvptest.data.models.simpsonmodels.Simpsons;


import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {


    //"http://api.duckduckgo.com/?q=simpsons+characters&format=json";

    @GET("?q=simpsons+characters&format=json")
    Call <Simpsons> getRelatedTopics();

//    @GET("?q=simpsons+characters&format=json")
//    Call <Simpsons> getRelatedTopics(@Query("q") String data, @Query("format") String format);

}

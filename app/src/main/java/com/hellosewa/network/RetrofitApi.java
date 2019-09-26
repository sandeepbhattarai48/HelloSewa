package com.hellosewa.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitApi {

    private String BASE_URL ="http://192.168.254.106:8086/";
//

    private static RetrofitApi instance;
    private LoginService loginService;


    public static RetrofitApi getInstance() {
        if (instance == null) {
            instance = new RetrofitApi();
        }

        return instance;
    }

    private RetrofitApi() {
        buildRetrofit(BASE_URL);
    }

    private void buildRetrofit(String url) {

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        loginService = retrofit.create(LoginService.class);
    }

    public LoginService getLoginService() {
        return loginService;
    }


}

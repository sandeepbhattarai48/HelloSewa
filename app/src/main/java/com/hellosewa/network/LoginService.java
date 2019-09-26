package com.hellosewa.network;

import com.hellosewa.Model.Login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LoginService {

    @POST("testlogin/test/checkLogin")
    Call<Void> login(@Body Login login);
}

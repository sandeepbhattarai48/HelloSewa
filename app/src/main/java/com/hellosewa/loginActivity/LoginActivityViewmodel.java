package com.hellosewa.loginActivity;

import android.app.Application;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.hellosewa.Model.Login;
import com.hellosewa.network.LoginService;
import com.hellosewa.network.RetrofitApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivityViewmodel extends AndroidViewModel {
    private static final String TAG = "LoginActivityViewmodel";
    public LoginActivityViewmodel(@NonNull Application application) {
        super(application);
    }

    LoginService loginService = RetrofitApi.getInstance().getLoginService();


    public void onClickLogin(EditText phoneEt, EditText passwordEt, View v){
        String phone = phoneEt.getText().toString();
        String password = passwordEt.getText().toString();

        if(!phone.isEmpty()&&!password.isEmpty()){
            Log.d(TAG, "onClickLogin: "+phone+" "+password);
            login(phone,password);
        }



    }

    private void login(String phone, String password) {
        Login login = new Login(phone,password);
        Call<Void> call = loginService.login(login);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d(TAG, "onResponse: "+response.body());


            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage() );
            }
        });


    }


}

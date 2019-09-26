package com.hellosewa.loginActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.EditText;

import com.hellosewa.MainActivity;
import com.hellosewa.R;

import java.util.Observable;

public class LoginActivity extends AppCompatActivity {
    ViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        viewModel = ViewModelProviders.of(this).get(LoginActivityViewmodel.class);
        final EditText phoneEt = findViewById(R.id.phone_edittext);
        final EditText passwordEt = findViewById(R.id.password_edittext);
        Button loginBtn = findViewById(R.id.login_btn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((LoginActivityViewmodel) viewModel).onClickLogin(phoneEt,passwordEt,v);
            }
        });

        ((LoginActivityViewmodel)viewModel).changeActivity().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if(s.equals("main")){
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }
            }
        });



    }
}

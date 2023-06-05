package com.example.earthquakeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.earthquakeapp.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private Intent afterMainIntent;
    private Intent signUpIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();

        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.username.getEditText().getText().toString();
                String password = binding.password.getEditText().getText().toString().trim();
                if(email.equals(""))
                {
                    binding.username.setError("E postanızı giriniz.");
                }
                else if(password.equals(""))
                {
                    binding.password.setError("Şifrenizi giriniz");
                }else
                {
                    afterMainIntent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(afterMainIntent);
                    // CheckData();
                }
            }


        });

        binding.txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpIntent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(signUpIntent);
            }
        });


    }
}

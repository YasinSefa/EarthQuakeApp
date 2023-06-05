package com.example.earthquakeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.earthquakeapp.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {
    private Intent afterMainIntent;

    private Intent signUpIntent;
    private ActivitySignupBinding binding;
    private Intent mainIntent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivitySignupBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();
        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        binding.txtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainIntent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(mainIntent);
            }
        });

        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.edtSignUpFullName.getEditText().getText().toString();
                String tel = binding.edtSignUpMobile.getEditText().getText().toString();
                String email = binding.edtSignUpEmail.getEditText().getText().toString();
                String sifre = binding.edtSignUpPassword.getEditText().getText().toString();
                String sifreOnay = binding.edtSignUpConfirmPassword.getEditText().getText().toString();
                if(name.equals(""))
                {
                    binding.edtSignUpFullName.setError("Adınızı ve soyadınızı giriniz.");
                }
                else if(email.equals(""))
                {
                    binding.edtSignUpEmail.setError("E mailinizi giriniz.");
                } else if (tel.equals(""))
                {
                    binding.edtSignUpMobile.setError("Telefon numaranızı giriniz.");
                } else if (sifre.equals("")) {
                    binding.edtSignUpPassword.setError("Şifrenizi giriniz.");
                } else if (sifreOnay.equals("")) {
                    binding.edtSignUpConfirmPassword.setError("Şifrenizi giriniz.");
                } else if (!sifre.equals(sifreOnay)) {
                    Toast.makeText(getApplicationContext(), "Şifre Uyuşmuyor", Toast.LENGTH_SHORT).show();
                } else
                {
                    boolean kayitSonucu = databaseHelper.kullaniciKaydet(name, email, sifre, tel);
                    if (kayitSonucu) {
                        Toast.makeText(getApplicationContext(), "Kayıt başarılı!", Toast.LENGTH_SHORT).show();

                        binding.edtSignUpFullName.getEditText().setText("");
                        binding.edtSignUpMobile.getEditText().setText("");
                        binding.edtSignUpEmail.getEditText().setText("");
                        binding.edtSignUpPassword.getEditText().setText("");
                        binding.edtSignUpConfirmPassword.getEditText().setText("");
                    } else {
                        Toast.makeText(getApplicationContext(), "Kayıt işlemi başarısız oldu!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}

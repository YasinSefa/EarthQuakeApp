package com.example.earthquakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.earthquakeapp.databinding.ActivityHelpBinding;

import java.util.List;

public class HelpActivity extends AppCompatActivity {

    private ActivityHelpBinding binding;
    private Button buttonPlus;
    private Button buttonMinus;
    private EditText editText;
    private ImageButton backButton;
    private DatabaseHelper databaseHelper;
    private int value = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityHelpBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();
        databaseHelper = new DatabaseHelper(this);

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String productName = binding.edtHelp.getEditText().getText().toString();
                String productComment = binding.edtHelpComment.getEditText().getText().toString();
                int numOfProducts = Integer.parseInt(binding.editText.getText().toString());

                if (productName.isEmpty() || productComment.isEmpty()) {
                    Toast.makeText(HelpActivity.this, "Lütfen tüm alanları doldurun", Toast.LENGTH_SHORT).show();
                } else {
                    boolean success = databaseHelper.yardimKaydet(productName, productComment, numOfProducts);
                    if (!success) {
                        Toast.makeText(HelpActivity.this, "Yardım başarıyla kaydedildi", Toast.LENGTH_SHORT).show();
                        clearFields();
                    } else {
                        Toast.makeText(HelpActivity.this, "Yardım kaydedilirken bir hata oluştu", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        binding.editText.setText(String.valueOf(value));
        binding.buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value++;
                binding.editText.setText(String.valueOf(value));
            }
        });

        binding.buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (value > 1) {
                    value--;
                    binding.editText.setText(String.valueOf(value));
                }
            }
        });


    }
    private void clearFields() {
        binding.edtHelp.getEditText().setText("");
        binding.edtHelpComment.getEditText().setText("");
        binding.editText.setText("1");
    }
}
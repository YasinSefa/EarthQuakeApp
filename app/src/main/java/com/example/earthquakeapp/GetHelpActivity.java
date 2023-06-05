package com.example.earthquakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.earthquakeapp.databinding.ActivityGetHelpBinding;
import com.example.earthquakeapp.databinding.ActivityHelpBinding;

import java.util.ArrayList;
import java.util.List;

public class GetHelpActivity extends AppCompatActivity {

    private ActivityGetHelpBinding binding;
    private ArrayList<String> helpList;
    private ArrayAdapter<String> adapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGetHelpBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();


        helpList = new ArrayList<>();
        helpList.add("Battaniye \t 2");
        helpList.add("Kiralık Ev \t 1");


        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, helpList);
        binding.listview.setAdapter(adapter);
    }



}
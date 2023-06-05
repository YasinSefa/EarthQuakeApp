package com.example.earthquakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;

import com.example.earthquakeapp.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Intent afterMainIntent;
    //private String[] items = {"Yorgan", "Yastık", "Ev", "Battaniye", "Erzak"};
    private String[] items = {"Yardım Almak İstiyorum", "Yardım Vermek İstiyorum"};
    private String[] inf = {"Deprem","Acil Durum Çantası"};
    private ImageButton backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, inf);
        binding.listview.setAdapter(adapter);
        binding.listview1.setAdapter(adapter1);

        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem = items[position];
                System.out.println(clickedItem);
                if (clickedItem == "Yardım Almak İstiyorum"){
                    //Intent intent = new Intent(MainActivity.this, EarthquakeActivity.class);
                    //intent.putExtra("itemTitle", clickedItem);
                    //startActivity(intent);
                } else if (clickedItem == "Yardım Vermek İstiyorum") {
                    //Intent intent = new Intent(MainActivity.this, EarthquakeActivity.class);
                    //intent.putExtra("itemTitle", clickedItem);
                    //startActivity(intent);
                }
            }
        });

        binding.listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem = inf[position];
                System.out.println(clickedItem);
                if (clickedItem == "Deprem"){
                    Intent intent = new Intent(MainActivity.this, EarthquakeActivity.class);
                    intent.putExtra("itemTitle", clickedItem);
                    startActivity(intent);
                } else if (clickedItem == "Acil Durum Çantası") {
                    Intent intent = new Intent(MainActivity.this, EarthquakeBagActivity.class);
                    intent.putExtra("itemTitle", clickedItem);
                    startActivity(intent);
                }
            }
        });

        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem = items[position];
                System.out.println(clickedItem);
                if (clickedItem == "Yardım Almak İstiyorum"){
                    Intent intent = new Intent(MainActivity.this, GetHelpActivity.class);
                    intent.putExtra("itemTitle", clickedItem);
                    startActivity(intent);
                } else if (clickedItem == "Yardım Vermek İstiyorum") {
                    Intent intent = new Intent(MainActivity.this, HelpActivity.class);
                    intent.putExtra("itemTitle", clickedItem);
                    startActivity(intent);
                }
            }
        });



    }
}
package com.example.healthy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;

public class MainScreenActivity extends AppCompatActivity {

    ImageView imgbtnFeel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        ImageButton imgbtnFood = (ImageButton) findViewById(R.id.food);
        ImageButton imgbtnExercise = (ImageButton) findViewById(R.id.exercise);
        ImageButton imgbtnSleep = (ImageButton) findViewById(R.id.sleep);
        ImageButton imgbtnWater = (ImageButton) findViewById(R.id.water);

        imgbtnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreenActivity.this, FoodActivity.class);
                startActivity(intent);
            }
        });

        imgbtnExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreenActivity.this, ActivitiesActivity.class);
                startActivity(intent);
            }
        });

        imgbtnSleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreenActivity.this, SleepActivity.class);
                startActivity(intent);
            }
        });

        imgbtnWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreenActivity.this, WaterActivity.class);
                startActivity(intent);
            }
        });

        imgbtnFeel = (ImageView) findViewById(R.id.feel);
        registerForContextMenu(imgbtnFeel);


    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        getMenuInflater().inflate(R.menu.context_menu, menu);
        menu.setHeaderTitle("Bạn cảm thấy thế nào?");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.a:
               //
            case R.id.b:
                //
            case R.id.c:
                //
            case R.id.d:
               //
            case R.id.e:
               //
            case R.id.f:
                //
            case R.id.g:
               //
        }
        return super.onContextItemSelected(item);
    }


}

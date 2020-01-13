package com.example.healthy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
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

import com.example.healthy.Dangky.Activity_Dangky1;

import java.io.BufferedReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainScreenActivity extends AppCompatActivity {

    ImageView imgbtnFeel;
    int label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        ActionBar actionBar = getSupportActionBar();
        String time = ProcessDate();
        actionBar.setTitle(time);

        ImageButton imgbtnFood = (ImageButton) findViewById(R.id.food);
        ImageButton imgbtnExercise = (ImageButton) findViewById(R.id.exercise);
        ImageButton imgbtnSleep = (ImageButton) findViewById(R.id.sleep);
        ImageButton imgbtnWater = (ImageButton) findViewById(R.id.water);
        ImageButton imgbtnAlarm = (ImageButton) findViewById(R.id.alarm);
        ImageButton imgbtnSta = (ImageButton) findViewById(R.id.statistic);
        ImageButton imgbtnRec = (ImageButton) findViewById(R.id.idea);
        ImageButton imgbtnSet = (ImageButton) findViewById(R.id.setting);

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

        imgbtnAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreenActivity.this, AlarmActivity.class);
                startActivity(intent);
            }
        });

        imgbtnSta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreenActivity.this, StatisticActivity.class);
                startActivity(intent);
            }
        });

        imgbtnRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreenActivity.this, RecommendActivity.class);
                startActivity(intent);
            }
        });

        imgbtnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreenActivity.this, Activity_Dangky1.class);
                startActivity(intent);
            }
        });

        imgbtnFeel = (ImageView) findViewById(R.id.feel);
        registerForContextMenu(imgbtnFeel);







    }

    private String ProcessDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String currentDate = sdf.format(new Date());
        return  currentDate;
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
                label=1;
            case R.id.b:
                label=2;
            case R.id.c:
                label=3;
            case R.id.d:
               label=4;
            case R.id.e:
               label=5;
            case R.id.f:
                label=6;
            case R.id.g:
                label=7;
        }
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
        return super.onContextItemSelected(item);
    }


}

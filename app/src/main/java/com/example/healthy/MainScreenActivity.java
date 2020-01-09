package com.example.healthy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        ImageButton imgbtnFood = (ImageButton) findViewById(R.id.food);
        ImageButton imgbtnDrink = (ImageButton) findViewById(R.id.drink);

        imgbtnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreenActivity.this, FoodActivity.class);
                startActivity(intent);
            }
        });

        imgbtnDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreenActivity.this, DrinkActivity.class);
                startActivity(intent);
            }
        });

    }





}

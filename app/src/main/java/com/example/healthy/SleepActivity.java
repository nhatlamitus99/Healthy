package com.example.healthy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInRightAnimationAdapter;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

public class SleepActivity extends AppCompatActivity {

    ArrayList<Item_RV> list;
    Adapter_RV adapter_rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);


        Init_ListFood();


        adapter_rv = new Adapter_RV(list, this);
        rv.setAdapter(new ScaleInAnimationAdapter(adapter_rv));
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));





        ImageButton btnOk = (ImageButton) findViewById(R.id.btnOK);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SleepActivity.this, MainScreenActivity.class);
                startActivity(intent);
            }
        });


    }



    private void Init_ListFood() {
        list = new ArrayList<Item_RV>();
        list.add(new Item_RV(R.drawable.night, "Ngủ Tối", 0));
        list.add(new Item_RV(R.drawable.sun, "Ngủ Trưa", 0));
    }
}

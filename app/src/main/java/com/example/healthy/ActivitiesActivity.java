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

public class ActivitiesActivity extends AppCompatActivity {

    ArrayList<Item_RV> list;
    Adapter_RV adapter_rv;
    ArrayList<Item_RV> list_drink;
    Adapter_RV adapter_rv_drink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        RecyclerView rv_drink = (RecyclerView) findViewById(R.id.rvDrink);

        Init_ListFood();
        Init_ListDrink();

        adapter_rv = new Adapter_RV(list, this);
        rv.setAdapter(new ScaleInAnimationAdapter(adapter_rv));
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapter_rv_drink = new Adapter_RV(list_drink, this);
        rv_drink.setAdapter(new ScaleInAnimationAdapter(adapter_rv_drink));
        rv_drink.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));




        ImageButton btnOk = (ImageButton) findViewById(R.id.btnOK);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivitiesActivity.this, MainScreenActivity.class);
                startActivity(intent);
            }
        });


    }

    private void Init_ListDrink() {
        list_drink = new ArrayList<Item_RV>();
        list_drink.add(new Item_RV(R.drawable.ruou, "Bóng Đá", 0));
        list_drink.add(new Item_RV(R.drawable.bia, "Cầu Lông", 0));
        list_drink.add(new Item_RV(R.drawable.trasua, "Cờ Vua", 0));
        list_drink.add(new Item_RV(R.drawable.nuocloc, "Golf", 0));
        list_drink.add(new Item_RV(R.drawable.coca, "Tennis", 0));
        list_drink.add(new Item_RV(R.drawable.soda, "Chạy Bộ", 0));
        list_drink.add(new Item_RV(R.drawable.ruou, "Bóng Đá", 0));
        list_drink.add(new Item_RV(R.drawable.bia, "Cầu Lông", 0));
        list_drink.add(new Item_RV(R.drawable.trasua, "Cờ Vua", 0));
        list_drink.add(new Item_RV(R.drawable.nuocloc, "Golf", 0));
        list_drink.add(new Item_RV(R.drawable.coca, "Tennis", 0));
        list_drink.add(new Item_RV(R.drawable.soda, "Chạy Bộ", 0));

    }

    private void Init_ListFood() {
        list = new ArrayList<Item_RV>();
        list.add(new Item_RV(R.drawable.rices, "Hít Đất", 0));
        list.add(new Item_RV(R.drawable.pho, "Xà Đơn", 0));
        list.add(new Item_RV(R.drawable.cake, "Swat", 0));
        list.add(new Item_RV(R.drawable.fastfood, "Đẩy Tạ", 0));
        list.add(new Item_RV(R.drawable.rices, "Hít Đất", 0));
        list.add(new Item_RV(R.drawable.pho, "Xà Đơn", 0));
        list.add(new Item_RV(R.drawable.cake, "Swat", 0));
        list.add(new Item_RV(R.drawable.fastfood, "Đẩy Tạ", 0));
    }
}

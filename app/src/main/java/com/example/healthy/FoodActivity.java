package com.example.healthy;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.healthy.Dangky.Item;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInRightAnimationAdapter;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

public class FoodActivity extends AppCompatActivity {

    ArrayList<Item_RV> list;
    Adapter_RV adapter_rv;
    ArrayList<Item_RV> list_drink;
    Adapter_RV adapter_rv_drink;

    ArrayList<Item> list_food = new ArrayList<Item>();
    ArrayList<Item> list_drinks = new ArrayList<Item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        ActionBar actionBar = getSupportActionBar();
        String time = ProcessDate();
        actionBar.setTitle(time);
        actionBar.setDisplayHomeAsUpEnabled(true);

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







    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                GetData();
                onBackPressed();
                return true;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void GetData() {
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).getNumber()!=0)
            {
                list_food.add(new Item(list.get(i).getTitle(), list.get(i).getNumber()));
            }
        }
        for(int i=0;i<list_drink.size();i++)
        {
            if(list.get(i).getNumber()!=0)
            {
                list_drinks.add(new Item(list.get(i).getTitle(), list.get(i).getNumber()));
            }
        }
        Toast.makeText(this, list_food.size()+ " món ăn và "+ list_drinks.size()+" thức uống \n đã được cập nhật !!!", Toast.LENGTH_LONG).show();
    }

    private String ProcessDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String currentDate = sdf.format(new Date());
        return  currentDate;
    }


    private void Init_ListDrink() {
        list_drink = new ArrayList<Item_RV>();
        list_drink.add(new Item_RV(R.drawable.ruou, "Rượu", 0));
        list_drink.add(new Item_RV(R.drawable.bia, "Bia", 0));
        list_drink.add(new Item_RV(R.drawable.trasua, "Trà Sữa", 0));
        list_drink.add(new Item_RV(R.drawable.nuocloc, "Nước Lọc", 0));
        list_drink.add(new Item_RV(R.drawable.coca, "Nước Ngọt", 0));
        list_drink.add(new Item_RV(R.drawable.soda, "Nước có Ga", 0));
        list_drink.add(new Item_RV(R.drawable.ruou, "Rượu", 0));
        list_drink.add(new Item_RV(R.drawable.bia, "Bia", 0));
        list_drink.add(new Item_RV(R.drawable.trasua, "Trà Sữa", 0));
        list_drink.add(new Item_RV(R.drawable.nuocloc, "Nước Lọc", 0));
        list_drink.add(new Item_RV(R.drawable.coca, "Nước Ngọt", 0));
        list_drink.add(new Item_RV(R.drawable.ga, "Nước có Ga", 0));

    }

    private void Init_ListFood() {
        list = new ArrayList<Item_RV>();
        list.add(new Item_RV(R.drawable.rices, "Cơm", 0));
        list.add(new Item_RV(R.drawable.pho, "Phở", 0));
        list.add(new Item_RV(R.drawable.cake, "Bánh Ngọt", 0));
        list.add(new Item_RV(R.drawable.fastfood, "Fast food", 0));
        list.add(new Item_RV(R.drawable.salad, "Salad", 0));
        list.add(new Item_RV(R.drawable.seafood, "Hải sản", 0));
        list.add(new Item_RV(R.drawable.rice, "Cơm", 0));
        list.add(new Item_RV(R.drawable.pho, "Phở", 0));
        list.add(new Item_RV(R.drawable.cake, "Bánh Ngọt", 0));
        list.add(new Item_RV(R.drawable.fastfood, "Fast food", 0));
        list.add(new Item_RV(R.drawable.salad, "Salad", 0));
        list.add(new Item_RV(R.drawable.seafood, "Hải sản", 0));
    }
}

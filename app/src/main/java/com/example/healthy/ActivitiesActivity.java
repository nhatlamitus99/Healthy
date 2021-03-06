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

public class ActivitiesActivity extends AppCompatActivity {

    ArrayList<Item_RV> list_act;
    Adapter_RV adapter_rv_act;
    ArrayList<Item> list_act_item = new ArrayList<Item>();

    ArrayList<Item_RV> list_gym;
    Adapter_RV adapter_rv_gym;
    ArrayList<Item> list_gym_item = new ArrayList<Item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);
        ActionBar actionBar = getSupportActionBar();
        String time = ProcessDate();
        actionBar.setTitle(time);
        actionBar.setDisplayHomeAsUpEnabled(true);

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv_activity);
        RecyclerView rv_drink = (RecyclerView) findViewById(R.id.rv_gym);

        Init_ListFood();
        Init_ListDrink();

        adapter_rv_act = new Adapter_RV(list_act, this);
        rv.setAdapter(new ScaleInAnimationAdapter(adapter_rv_act));
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapter_rv_gym = new Adapter_RV(list_gym, this);
        rv_drink.setAdapter(new ScaleInAnimationAdapter(adapter_rv_gym));
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
        for(int i=0;i<list_act.size();i++)
        {
            if(list_act.get(i).getNumber()!=0)
            {
                list_act_item.add(new Item(list_act.get(i).getTitle(), list_act.get(i).getNumber()));
            }
        }
        for(int i=0;i<list_gym.size();i++)
        {
            if(list_gym.get(i).getNumber()!=0)
            {
                list_gym_item.add(new Item(list_gym.get(i).getTitle(), list_gym.get(i).getNumber()));
            }
        }
        Toast.makeText(this, list_act_item.size()+ " hoạt động và "+ list_gym_item.size()+" bài tập gym \n đã được cập nhật !!!", Toast.LENGTH_SHORT).show();

    }

    private String ProcessDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String currentDate = sdf.format(new Date());
        return  currentDate;
    }


    private void Init_ListDrink() {
        list_act = new ArrayList<Item_RV>();
        list_act.add(new Item_RV(R.drawable.ruou, "Bóng Đá", 0));
        list_act.add(new Item_RV(R.drawable.bia, "Cầu Lông", 0));
        list_act.add(new Item_RV(R.drawable.trasua, "Cờ Vua", 0));
        list_act.add(new Item_RV(R.drawable.nuocloc, "Golf", 0));
        list_act.add(new Item_RV(R.drawable.coca, "Tennis", 0));
        list_act.add(new Item_RV(R.drawable.soda, "Chạy Bộ", 0));
        list_act.add(new Item_RV(R.drawable.ruou, "Bóng Đá", 0));
        list_act.add(new Item_RV(R.drawable.bia, "Cầu Lông", 0));
        list_act.add(new Item_RV(R.drawable.trasua, "Cờ Vua", 0));
        list_act.add(new Item_RV(R.drawable.nuocloc, "Golf", 0));
        list_act.add(new Item_RV(R.drawable.coca, "Tennis", 0));
        list_act.add(new Item_RV(R.drawable.soda, "Chạy Bộ", 0));

    }

    private void Init_ListFood() {
        list_gym = new ArrayList<Item_RV>();
        list_gym.add(new Item_RV(R.drawable.rices, "Hít Đất", 0));
        list_gym.add(new Item_RV(R.drawable.pho, "Xà Đơn", 0));
        list_gym.add(new Item_RV(R.drawable.cake, "Swat", 0));
        list_gym.add(new Item_RV(R.drawable.fastfood, "Đẩy Tạ", 0));
        list_gym.add(new Item_RV(R.drawable.rices, "Hít Đất", 0));
        list_gym.add(new Item_RV(R.drawable.pho, "Xà Đơn", 0));
        list_gym.add(new Item_RV(R.drawable.cake, "Swat", 0));
        list_gym.add(new Item_RV(R.drawable.fastfood, "Đẩy Tạ", 0));
    }
}

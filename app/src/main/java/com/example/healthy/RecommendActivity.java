package com.example.healthy;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class RecommendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Lời khuyên cho bạn ");
        actionBar.setDisplayHomeAsUpEnabled(true);

        int[] x = {1,2,3,4};
        int[] y = {0,1,0,1};

        LinearRegression linearRegression = new LinearRegression(x,y);
        Toast.makeText(this, linearRegression.toString(), Toast.LENGTH_LONG).show();


    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:

                onBackPressed();
                return true;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }



}

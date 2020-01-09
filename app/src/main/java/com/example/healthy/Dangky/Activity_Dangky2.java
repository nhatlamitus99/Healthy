package com.example.healthy.Dangky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.healthy.MainScreenActivity;
import com.example.healthy.R;

public class Activity_Dangky2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__dangky2);

        ImageButton btnNext = (ImageButton) this.findViewById(R.id.next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Dangky2.this, MainScreenActivity.class);
                startActivity(intent);
            }
        });

    }
}

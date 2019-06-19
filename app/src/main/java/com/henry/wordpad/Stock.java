package com.henry.wordpad;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Stock extends AppCompatActivity {
    TextView show;
    Button Btn;

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);
        show = findViewById(R.id.btn_step);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Stock.this, StockListActivity.class);
                startActivity(intent);
            }

        });

        Btn = findViewById(R.id.btn_return_5);
        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Stock.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}



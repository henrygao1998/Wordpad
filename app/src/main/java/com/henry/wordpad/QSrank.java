package com.henry.wordpad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class QSrank extends AppCompatActivity {

    Button Btn1;
    Button Btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qsrank);
        Btn1 = findViewById(R.id.next1);
        Btn2 = findViewById(R.id.back0);

        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(QSrank.this, QSrank2.class);
                startActivity(intent);
            }
        });

        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(QSrank.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}


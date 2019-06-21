package com.henry.wordpad;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Education extends AppCompatActivity {
    Button Btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);
        Btn = findViewById(R.id.btn_return_1);
        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Education.this, MainActivity.class);
                startActivity(intent);
            }
        });
        ViewPager viewPager = findViewById(R.id.viewpager);
        EducationAdapter pageAdapter = new EducationAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);
        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

    }
}

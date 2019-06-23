package com.henry.wordpad;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class More extends FragmentActivity {

    Button Btn;

    private Fragment mFragments[];
    private RadioGroup radioGroup;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private RadioButton rbtFirst, rbtSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        Btn = findViewById(R.id.btn_return_6);
        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(More.this, MainActivity.class);
                startActivity(intent);
            }
        });

        mFragments = new Fragment[2];
        fragmentManager = getSupportFragmentManager();
        mFragments[0] = fragmentManager.findFragmentById(R.id.fragment_main);
        mFragments[1] = fragmentManager.findFragmentById(R.id.fragment_func);
        fragmentTransaction = fragmentManager.beginTransaction().hide(mFragments[0]).hide(mFragments[1]);
        fragmentTransaction.show(mFragments[0]).commit();

        rbtFirst = findViewById(R.id.radioFirst);
        rbtSecond = findViewById(R.id.radioSecond);

        rbtFirst.setBackgroundResource(R.drawable.shape2);

        radioGroup = findViewById(R.id.bottomGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                fragmentTransaction = fragmentManager.beginTransaction().hide(mFragments[0]).hide(mFragments[1]);

                rbtFirst.setBackgroundResource(R.drawable.shape1);
                rbtSecond.setBackgroundResource(R.drawable.shape1);

                switch (checkedId) {
                    case R.id.radioFirst:
                        fragmentTransaction.show(mFragments[0]).commit();
                        rbtFirst.setBackgroundResource(R.drawable.shape2);
                        break;
                    case R.id.radioSecond:
                        fragmentTransaction.show(mFragments[1]).commit();
                        rbtSecond.setBackgroundResource(R.drawable.shape2);
                        break;
                    default:
                        break;
                }

            }
        });


    }
}

package com.henry.wordpad;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView mImgMenu;
    /**导航栏左侧的侧边栏的父容器*/
    private DrawerLayout mDrawerLayout;
    //导航视图
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initEvents();
    }

    private void initViews() {
        mImgMenu = findViewById(R.id.img_menu);
        mDrawerLayout = findViewById(R.id.id_drawerLayout);
        mNavigationView = findViewById(R.id.nav_view);
    }

    private void initEvents() {
        //用户图标的点击事件
        mImgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.menu_info:
                        /* 新建一个Intent对象 */
                        Intent intent = new Intent();
                        /* 指定intent要启动的类 */
                        intent.setClass(MainActivity.this, News.class);
                        /* 启动一个新的Activity */
                        startActivity(intent);
                        /* 关闭当前的Activity */
                        MainActivity.this.finish();
                        break;
                        //Toast.makeText(MainActivity.this, "个人信息", Toast.LENGTH_SHORT).show();

                    case R.id.menu_pwd:
                        Toast.makeText(MainActivity.this, "修改密码", Toast.LENGTH_SHORT).show();
                        break;
                }
                //关闭侧滑菜单
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }
}

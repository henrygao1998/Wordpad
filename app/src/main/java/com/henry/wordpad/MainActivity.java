package com.henry.wordpad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.AbsListView.OnScrollListener.SCROLL_STATE_FLING;
import static android.widget.AbsListView.OnScrollListener.SCROLL_STATE_IDLE;
import static android.widget.NumberPicker.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL;


public class MainActivity extends AppCompatActivity implements OnScrollListener, OnItemClickListener, OnItemLongClickListener {
    private Context mContext;
    private ListView listview;
    private SimpleAdapter simp_adapter;
    private List<Map<String, Object>> dataList;
    private Button addNote;
    private TextView tv_content;
    private NotesDB DB;
    private SQLiteDatabase dbread;

    private ListView listview1;
    private List<Map<String, Object>> personalList = new ArrayList<Map<String, Object>>();
    private List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
    private EditText editText;
    private SimpleAdapter adapter;


    private ImageView mImgMenu;
    /**
     * 导航栏左侧的侧边栏的父容器
     */
    private DrawerLayout mDrawerLayout;
    //导航视图
    private NavigationView mNavigationView;
    Button Btn1;
    Button Btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        tv_content = findViewById(R.id.tv_content);
        listview = findViewById(R.id.listview);
        dataList = new ArrayList<Map<String, Object>>();
        mContext = this;


        initViews();
        initEvents();
        Btn1 = findViewById(R.id.btn_personal);
        Btn2 = findViewById(R.id.btn_trash);
        addNote = findViewById(R.id.btn_edit);
        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit.ENTER_STATE = 0;
                Intent intent = new Intent(mContext, Edit.class);
                Bundle bundle = new Bundle();
                bundle.putString("info", "");
                intent.putExtras(bundle);
                startActivityForResult(intent, 1);
            }
        });
        DB = new NotesDB(this);
        dbread = DB.getReadableDatabase();
        // 清空数据库中表的内容
        //dbread.execSQL("delete from note");
        RefreshNotesList();
        listview.setOnItemClickListener(this);
        listview.setOnItemLongClickListener(this);
        listview.setOnScrollListener(this);


        Btn1.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Personal.class);
                startActivity(intent);
            }
        });
        Btn2.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Delete.class);
                startActivity(intent);
            }
        });

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
                switch (item.getItemId()) {
                    case R.id.menu_news:
                        /* 新建一个Intent对象 */
                        Intent intent1 = new Intent();
                        /* 指定intent要启动的类 */
                        intent1.setClass(MainActivity.this, News.class);
                        /* 启动一个新的Activity */
                        startActivity(intent1);
                        /* 关闭当前的Activity */
                        MainActivity.this.finish();
                        break;
                    //Toast.makeText(MainActivity.this, "个人信息", Toast.LENGTH_SHORT).show();

                    case R.id.menu_stock:
                        Intent intent2 = new Intent();
                        intent2.setClass(MainActivity.this, Stock.class);
                        startActivity(intent2);
                        MainActivity.this.finish();
                        break;
                }
                //关闭侧滑菜单
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }


    public void RefreshNotesList() {
        int size = dataList.size();
        if (size > 0) {
            dataList.removeAll(dataList);
            simp_adapter.notifyDataSetChanged();
            listview.setAdapter(simp_adapter);
        }
        simp_adapter = new SimpleAdapter(this, getData(), R.layout.acitivity_listview, new String[]{"tv_content", "tv_date"}, new int[]{R.id.tv_content, R.id.tv_date});
        listview.setAdapter(simp_adapter);
    }

    private List<Map<String, Object>> getData() {
        Cursor cursor = dbread.query("note", null, "content!=\"\"", null, null, null, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("content"));
            String date = cursor.getString(cursor.getColumnIndex("date"));
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("tv_content", name);
            map.put("tv_date", date);
            dataList.add(map);
        }
        cursor.close();
        return dataList;
    }

    @Override
    public void onScroll(AbsListView arg0, int arg1, int arg2, int arg3) {
        // TODO Auto-generated method stub
    }

    // 滑动listview监听事件
    @Override
    public void onScrollStateChanged(AbsListView arg0, int arg1) {
        // TODO Auto-generated method stub
        switch (arg1) {
            case SCROLL_STATE_FLING:
                Log.i("main", "用户在手指离开屏幕之前，由于用力的滑了一下，视图能依靠惯性继续滑动");
            case SCROLL_STATE_IDLE:
                Log.i("main", "视图已经停止滑动");
            case SCROLL_STATE_TOUCH_SCROLL:
                Log.i("main", "手指没有离开屏幕，试图正在滑动");
        }
    }

    // 点击listview中某一项的监听事件

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        Edit.ENTER_STATE = 1;


        String content = listview.getItemAtPosition(arg2) + "";
        String content1 = content.substring(content.indexOf("tv_content="));
        String content2 = content1.substring(content1.indexOf("=") + 1, content1.indexOf("}"));
        Cursor c = dbread.query("note", null, "content=" + "'" + content2 + "'", null, null, null, null);

        Log.d("CONTENT1", content1);
        Log.d("CONTENT2", content2);

        while (c.moveToNext()) {
            String No = c.getString(c.getColumnIndex("_id"));
            Log.i("TEXT", No);
            Intent myIntent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("info", content2);
            Edit.id = Integer.parseInt(No);
            myIntent.putExtras(bundle);
            myIntent.setClass(MainActivity.this, Edit.class);
            startActivityForResult(myIntent, 1);
        }
    }

    @Override
    // 接受上一个页面返回的数据，并刷新页面
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2) {
            RefreshNotesList();
        }
    }
    // 点击listview中某一项长时间的点击事件

    @Override
    public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        final int n = arg2;
        Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("删除该日志");
        builder.setMessage("确认删除吗？");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String content = listview.getItemAtPosition(n) + "";
                String content1 = content.substring(content.indexOf("tv_content="));
                String content2 = content1.substring(content1.indexOf("=") + 1, content1.indexOf("}"));
                Cursor c = dbread.query("note", null, "content=" + "'" + content2 + "'", null, null, null, null);
                while (c.moveToNext()) {
                    String id = c.getString(c.getColumnIndex("_id"));
                    String sql_del = "update note set content='' where _id=" + id;
                    dbread.execSQL(sql_del);
                    RefreshNotesList();
                }
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.create();
        builder.show();
        return true;
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

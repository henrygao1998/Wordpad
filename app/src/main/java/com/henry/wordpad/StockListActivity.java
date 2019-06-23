package com.henry.wordpad;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class StockListActivity extends ListActivity implements Runnable {
    String data[] = {"请稍后，即将获得最新股票行业相关信息，每分钟更新一次。。。"};
    Handler handler;
    private String logDate = "";
    private final String DATE_SP_KEY = "lastStockDateStr";

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // setContentView(R.layout.activity_rate_list);
            SharedPreferences sp = getSharedPreferences("mystock",Context.MODE_PRIVATE);
            logDate = sp.getString(DATE_SP_KEY,"");
            //Log.i("list","lastStockDateStr=" + logDate);

            List<String> list1 = new ArrayList<String>();
            for(int i=1;i<100;i++){
                list1.add("item" + i);
            }
            ListAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
            setListAdapter(adapter);

            Thread t = new Thread(this);
            t.start();

            handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if(msg.what==7){
                    List<String> list2 = (List<String>) msg.obj;
                    ListAdapter adapter = new ArrayAdapter<String>(StockListActivity.this,android.R.layout.simple_list_item_1,list2);
                    setListAdapter(adapter);
                }
                super.handleMessage(msg);
            }
        };

    }

    @Override
    public void run() {
        //获取网络数据、放入list带回到主线程中
        List<String> retList = new ArrayList<>();
        String StockDateStr = (new SimpleDateFormat("yyyy-MM-dd HH:mm" )).format(new Date());
        //Log.i("run","StockDateStr:" + StockDateStr + "logDate:" + logDate);

        if(StockDateStr.equals(logDate)){
            //如果相等，则不从网络中获取数据
            Log.i("run","日期相等，从数据库中获取数据");
            StockManager manager = new StockManager(this);
            for(StockItem item : manager.listAll()){
                retList.add("行业： "+item.getStockName() + "  涨跌幅：" + item.getStockIndex() +"                                                             "+"领涨股： "+ item.getStockLead()+ "  涨跌幅：" +item.getStockRange());
            }
        }else{
            //从网络获取数据
            Log.i("run","日期不相等，从网络中获取数据");
            Document doc = null;
            try {
                Thread.sleep(6000);
                doc = Jsoup.connect("http://data.10jqka.com.cn/funds/hyzjl/").get();
                Elements tables = doc.getElementsByTag("table");
                Element table1 = tables.get(0);

                //获取TD中的数据
                Elements tds = table1.getElementsByTag("td");
                List<StockItem> indexList = new ArrayList<StockItem>();

                for(int i = 1;i<tds.size();i+= 11) {
                    Element td1 = tds.get(i);
                    Element td2 = tds.get(i+2);
                    Element td3 = tds.get(i+7);
                    Element td4 = tds.get(i+8);

                    String str1 = td1.text();
                    String str2 = td2.text();
                    String str3 = td3.text();
                    String str4 = td4.text();

                   // Log.i(TAG,"run:" + str1 + "==>" + val);
                    retList.add("行业： "+str1 + "  涨跌幅：" + str2 +"                                                             "+"领涨股： "+ str3 + "  涨跌幅：" +str4);
                    indexList.add(new StockItem(str1,str2,str3,str4));
                }

                //把数据写入到数据库中
                StockManager manager = new StockManager(this);
                manager.deleteAll();
                manager.addAll(indexList);

                //记录更新日期
                SharedPreferences sp = getSharedPreferences("mystock",Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = sp.edit();
                edit.putString(DATE_SP_KEY, StockDateStr);
                edit.commit();

                Log.i("run","更新日期结束：" + StockDateStr);


            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        Message msg = handler.obtainMessage(7);
        msg.obj = retList;
        handler.sendMessage(msg);
    }
}

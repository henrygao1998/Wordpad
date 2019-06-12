package com.henry.wordpad;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FuncA extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.activity_func_a,container);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        TextView tv = getView().findViewById(R.id.funcTextA);
        tv.setText("动物：    动物分类学家根据动物的各种特征（形态、细胞、遗传、生理、生态和地理分布等）进行分类，将动物依次分为6个主要等级，即门、纲、目、科、属、种。");
    }

}
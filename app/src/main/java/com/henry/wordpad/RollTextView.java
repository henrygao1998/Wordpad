package com.henry.wordpad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;


public class RollTextView extends LinearLayout {

    private Context c;
    private ViewFlipper vf;
    private View rtv;
    private String[] textArrays;
    private RollTextViewClickListener rollTextViewClickListener;

    public RollTextView(Context context) {
        super(context);
        c = context;
        initBasicView();
    }


    public RollTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        c = context;
        initBasicView();
    }

    public void setTextArraysAndClickListener(String[] textArrays, RollTextViewClickListener rollTextViewClickListener) {
        this.textArrays = textArrays;
        this.rollTextViewClickListener = rollTextViewClickListener;
        initRollTextView(textArrays, rollTextViewClickListener);
    }

    public void initBasicView() {
        rtv = LayoutInflater.from(c).inflate(R.layout.roll_textview, null);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        addView(rtv, layoutParams);
        vf = rtv.findViewById(R.id.viewFlipper);
        vf.setInAnimation(AnimationUtils.loadAnimation(c, R.anim.slide_in_bottom));
        vf.setOutAnimation(AnimationUtils.loadAnimation(c, R.anim.slide_out_top));
        vf.startFlipping();
    }

    public void initRollTextView(String[] textArrays, RollTextViewClickListener rollTextViewClickListener) {
        if (textArrays.length == 0) {
            return;
        }

        int i = 0;
        vf.removeAllViews();
        while (i < textArrays.length) {
            TextView tv = new TextView(c);
            tv.setText(textArrays[i]);
            tv.setOnClickListener(rollTextViewClickListener);
            LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            vf.addView(tv, lp);
            i++;
        }
    }

    public void releaseResources() {
        if (rtv != null) {
            if (vf != null) {
                vf.stopFlipping();
                vf.removeAllViews();
                vf = null;
            }
            rtv = null;
        }
    }

}

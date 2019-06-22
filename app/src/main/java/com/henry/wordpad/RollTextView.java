package com.henry.wordpad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.henry.wordpad.R;
import com.henry.wordpad.RollTextViewClickListener;

public class RollTextView extends LinearLayout {

    private Context mContext;
    private ViewFlipper viewFlipper;
    private View rollTextView;
    private String[] textArrays;
    private RollTextViewClickListener rollTextViewClickListener;

    public RollTextView(Context context) {
        super(context);
        mContext = context;
        initBasicView();
    }


    public RollTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initBasicView();
    }

    public void setTextArraysAndClickListener(String[] textArrays, RollTextViewClickListener rollTextViewClickListener) {
        this.textArrays = textArrays;
        this.rollTextViewClickListener = rollTextViewClickListener;
        initRollTextView(textArrays, rollTextViewClickListener);
    }

    public void initBasicView() {
        rollTextView = LayoutInflater.from(mContext).inflate(R.layout.roll_textview_layout, null);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        addView(rollTextView, layoutParams);
        viewFlipper = (ViewFlipper) rollTextView.findViewById(R.id.viewFlipper);
        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.slide_in_bottom));
        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(mContext, R.anim.slide_out_top));
        viewFlipper.startFlipping();
    }

    public void initRollTextView(String[] textArrays, RollTextViewClickListener rollTextViewClickListener) {
        if (textArrays.length == 0) {
            return;
        }

        int i = 0;
        viewFlipper.removeAllViews();
        while (i < textArrays.length) {
            TextView textView = new TextView(mContext);
            textView.setText(textArrays[i]);
            textView.setOnClickListener(rollTextViewClickListener);
            LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            viewFlipper.addView(textView, lp);
            i++;
        }
    }

    public void releaseResources() {
        if (rollTextView != null) {
            if (viewFlipper != null) {
                viewFlipper.stopFlipping();
                viewFlipper.removeAllViews();
                viewFlipper = null;
            }
            rollTextView = null;
        }
    }

}

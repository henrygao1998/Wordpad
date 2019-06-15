package com.henry.wordpad;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.telephony.TelephonyManager;
import android.widget.Toast;



public class UIUtils {

    private static Toast toast;
    private static TelephonyManager tm;


    /**
     * 静态吐司
     *
     * @param context
     * @param text
     */
    public static void showToast(Context context, String text) {
        if (toast == null) {
            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        }
        toast.setText(text);
        toast.show();
    }

    /**
     * 不需要上下文对象的  静态toast
     */
    public static void showToast(String text) {
        showToast(getContext(), text);
    }

    /**
     * 在子线程里弹出Toast
     *
     * @param text
     */
    public static void showToastInChildThread(Activity getActivity, final String text) {
        getActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showToast(text);
            }
        });
    }

    /**
     * 通过id 获取string-array
     *
     * @param tabNames
     */
    public static String[] getStringArray(int tabNames) {
        return getResources().getStringArray(tabNames);
    }

    private static Resources getResources() {
        return getContext().getResources();
    }

    /**
     * 获取上下文对象
     *
     * @return
     */
    public static Context getContext() {

        return MyApplication.getInstence();
    }



    /**
     * 获取SIM硬件信息
     *
     * @return
     */
    public static TelephonyManager getTelephonyManager() {
        if (tm == null)
            tm = (TelephonyManager) UIUtils.getContext().getSystemService(Context.TELEPHONY_SERVICE);
        return tm;
    }
}

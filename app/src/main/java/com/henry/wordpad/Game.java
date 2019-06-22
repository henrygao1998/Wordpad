package com.henry.wordpad;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Game extends AppCompatActivity {
    private SensorManager sensorManager;
    private Vibrator vibrator;
    private static String strs[] = {"石头", "剪刀", "布"};
    private static int pics[] = {R.drawable.edit, R.drawable.menu, R.drawable.personal};

    private static final int SENSOR_SHAKE = 10;

    private TextView text;
    private ImageView img;
    Button Btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        text = findViewById(R.id.txtlabel);
        img = findViewById(R.id.imageView);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        Btn1 = findViewById(R.id.btn_return_7);
        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Game.this, MainActivity.class);
                startActivity(intent);
            }

        });
    }

    protected void onResume(){
        super.onResume();
        if(sensorManager != null){
            sensorManager.registerListener(sensorEventListener,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
        }
    }


    protected void onStop(){
        super.onStop();
        if(sensorManager !=null){
            sensorManager.unregisterListener(sensorEventListener);
            }
        }



    //重力感应监听
    private SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            //传感器信息改变时执行该方法
            float[] values = event.values;
            float x = values[0];//x轴方向的重力加速度，向右为正
            float y = values[1];//y轴方向的重力加速度，向前为正
            float z = values[2];//z轴方向的重力加速度，向上为正
            //一般40+就可以达到摇晃手机的状态
            int medumValue = 10;//不同手机可能不同
            if (Math.abs(x) > medumValue || Math.abs(y) > medumValue || Math.abs(z) > medumValue) {
                vibrator.vibrate(200);
                Message msg = new Message();
                msg.what = SENSOR_SHAKE;
                handler.sendMessage(msg);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            switch(msg.what){
                case SENSOR_SHAKE:
                //检测到摇晃，执行操作
                java.util.Random r = new java.util.Random();
                int num = Math.abs(r.nextInt())%3;
                text.setText(strs[num]);
                img.setImageResource(pics[num]);
                break;
            }
        }

    };
}

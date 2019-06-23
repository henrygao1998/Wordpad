package com.henry.wordpad;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Dial extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dial);

        Intent Intent = new Intent(android.content.Intent.ACTION_DIAL, Uri.parse("tel:" + "028-87092908"));
        startActivity(Intent);

    }


}

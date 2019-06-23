package com.henry.wordpad;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ListChange extends Activity {
    
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.unviersity_model);
		
		Bundle bundle=getIntent().getExtras();
		int id = bundle.getInt("picture");
		String detail=bundle.getString("detail");
		ImageView Iv= findViewById(R.id.Iv);
		Iv.setImageResource(id);
		TextView tv= findViewById(R.id.tv_message);
		tv.setText(detail);
		
		
	}
	
}

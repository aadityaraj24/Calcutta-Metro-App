package com.example.calcuttametroapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ActivityHomePage extends Activity {
	ImageButton btn1;
	ImageButton btn2;
	ImageButton btn3;
	ImageButton btn4;
	ImageButton btn5;
	ImageButton btn6;
	ImageButton btn7;
    Button btn8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        btn1=(ImageButton)findViewById(R.id.imageButton1);
        btn2=(ImageButton)findViewById(R.id.imageButton2);
        btn3=(ImageButton)findViewById(R.id.imageButton3);
        btn4=(ImageButton)findViewById(R.id.imageButton4);
        btn5=(ImageButton)findViewById(R.id.imageButton5);
        btn6=(ImageButton)findViewById(R.id.imageButton6);
        btn7=(ImageButton)findViewById(R.id.imageButton7);
        btn8=(Button)findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(ActivityHomePage.this,ActivityStation.class);
				startActivity(i);
			}
		});
        
 btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(ActivityHomePage.this,ActivityTravelInfo.class);
				startActivity(i);
			}
		});
 btn3.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(ActivityHomePage.this,ActivityTrainTime.class);
			startActivity(i);
		}
	});
 btn4.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(ActivityHomePage.this,ActivityHelpline.class);
			startActivity(i);
		}
	});
 btn5.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(ActivityHomePage.this,ActivitySmartcard.class);
			startActivity(i);
		}
	});
 btn6.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(ActivityHomePage.this,ActivityRoute.class);
			startActivity(i);
		}
	});
 btn7.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(ActivityHomePage.this,ActivityInfo.class);
			startActivity(i);
		}
	});
 btn8.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(ActivityHomePage.this,ActivityAbout.class);
			startActivity(i);
		}
	});
 
 
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

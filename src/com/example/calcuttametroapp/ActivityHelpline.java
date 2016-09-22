package com.example.calcuttametroapp;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class ActivityHelpline extends Activity {
	MediaPlayer mp;
	Button btn1;
	Button btn2;
	Button btn3;
	Button btn4;
	Button btn5;
	Button btn6;
	Button btn7;
	Button btn8;
	Button btn9;
	Button btn10;
	Button btn11;
	Button btn12;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_helpline);
	 mp = MediaPlayer.create(getBaseContext(),R.raw.helplinee);
		  mp.start();
		btn1=(Button)findViewById(R.id.TextView09);
		btn2=(Button)findViewById(R.id.TextView10);
		btn3=(Button)findViewById(R.id.TextView07);
		btn4=(Button)findViewById(R.id.TextView08);
		btn5=(Button)findViewById(R.id.TextView05);
		btn6=(Button)findViewById(R.id.TextView06);
		btn7=(Button)findViewById(R.id.textView1);
		btn8=(Button)findViewById(R.id.textView2);
		btn9=(Button)findViewById(R.id.TextView02);
		btn10=(Button)findViewById(R.id.TextView01);
		btn11=(Button)findViewById(R.id.TextView04);
		btn12=(Button)findViewById(R.id.TextView03);
		btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent callIntent = new Intent(Intent.ACTION_CALL);
			    callIntent.setData(Uri.parse("tel:9007041908"));
			    startActivity(callIntent);
			}
		});
         btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent callIntent = new Intent(Intent.ACTION_CALL);
			    callIntent.setData(Uri.parse("tel:9007041908"));
			    startActivity(callIntent);
			}
		});
         btn3.setOnClickListener(new View.OnClickListener() {
 			
 			@Override
 			public void onClick(View v) {
 				// TODO Auto-generated method stub
 				Intent callIntent = new Intent(Intent.ACTION_CALL);
 			    callIntent.setData(Uri.parse("tel:9007041789"));
 			    startActivity(callIntent);
 			}
 		});
         btn4.setOnClickListener(new View.OnClickListener() {
  			
  			@Override
  			public void onClick(View v) {
  				// TODO Auto-generated method stub
  				Intent callIntent = new Intent(Intent.ACTION_CALL);
  			    callIntent.setData(Uri.parse("tel:9007041789"));
  			    startActivity(callIntent);
  			}
  		});
         btn5.setOnClickListener(new View.OnClickListener() {
  			
  			@Override
  			public void onClick(View v) {
  				// TODO Auto-generated method stub
  				Intent callIntent = new Intent(Intent.ACTION_CALL);
  			    callIntent.setData(Uri.parse("tel:03322263959"));
  			    startActivity(callIntent);
  			}
  		});
         btn6.setOnClickListener(new View.OnClickListener() {
   			
   			@Override
   			public void onClick(View v) {
   				// TODO Auto-generated method stub
   				Intent callIntent = new Intent(Intent.ACTION_CALL);
   			    callIntent.setData(Uri.parse("tel:03322263959"));
   			    startActivity(callIntent);
   			}
   		});
         btn7.setOnClickListener(new View.OnClickListener() {
   			
   			@Override
   			public void onClick(View v) {
   				// TODO Auto-generated method stub
   				Intent callIntent = new Intent(Intent.ACTION_CALL);
   			    callIntent.setData(Uri.parse("tel:033222143230"));
   			    startActivity(callIntent);
   			}
   		});
         btn8.setOnClickListener(new View.OnClickListener() {
    			
    			@Override
    			public void onClick(View v) {
    				// TODO Auto-generated method stub
    				Intent callIntent = new Intent(Intent.ACTION_CALL);
    			    callIntent.setData(Uri.parse("tel:033222143230"));
    			    startActivity(callIntent);
    			}
    		});
         btn9.setOnClickListener(new View.OnClickListener() {
    			
    			@Override
    			public void onClick(View v) {
    				// TODO Auto-generated method stub
    				Intent callIntent = new Intent(Intent.ACTION_CALL);
    			    callIntent.setData(Uri.parse("tel:100"));
    			    startActivity(callIntent);
    			}
    		});
         btn10.setOnClickListener(new View.OnClickListener() {
 			
 			@Override
 			public void onClick(View v) {
 				// TODO Auto-generated method stub
 				Intent callIntent = new Intent(Intent.ACTION_CALL);
 			    callIntent.setData(Uri.parse("tel:100"));
 			    startActivity(callIntent);
 			}
 		});
         btn11.setOnClickListener(new View.OnClickListener() {
 			
 			@Override
 			public void onClick(View v) {
 				// TODO Auto-generated method stub
 				Intent callIntent = new Intent(Intent.ACTION_CALL);
 			    callIntent.setData(Uri.parse("tel:101"));
 			    startActivity(callIntent);
 			}
 		});
         btn12.setOnClickListener(new View.OnClickListener() {
  			
  			@Override
  			public void onClick(View v) {
  				// TODO Auto-generated method stub
  				Intent callIntent = new Intent(Intent.ACTION_CALL);
  			    callIntent.setData(Uri.parse("tel:101"));
  			    startActivity(callIntent);
  			}
  		});
		
		
	}
	 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_helpline, menu);
		return true;
	}
	  @Override
	    public void onPause()
	    {
	       super.onPause();
	       if(mp.isPlaying())
	       mp.stop();
	       else
	       return;
	    }

	    @Override
	    public void onStop()
	    {
	       super.onStop();
	      if(mp.isPlaying())
	        mp.stop();
	      else
	       return;
	    }
	    
}

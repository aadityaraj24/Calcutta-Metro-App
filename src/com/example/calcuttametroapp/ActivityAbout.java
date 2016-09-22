package com.example.calcuttametroapp;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class ActivityAbout extends Activity {
	MediaPlayer mp;
	Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		 mp = MediaPlayer.create(getBaseContext(),R.raw.feedbacksound);
		  mp.start();
		btn=(Button)findViewById(R.id.button1);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i;
				PackageManager manager = getPackageManager();
				
				   i = manager.getLaunchIntentForPackage("com.google.android.gm");
				if (i == null)
				{
					Uri uri = Uri.parse("https://mail.google.com/mail/u/0/#inbox?compose=new"); 
					Intent intent = new Intent(Intent.ACTION_VIEW, uri);
					startActivity(intent);
				}
				i.addCategory(Intent.CATEGORY_LAUNCHER);
				startActivity(i);
				
				
			}
		});
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_about, menu);
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

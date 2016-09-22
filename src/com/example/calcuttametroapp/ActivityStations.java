package com.example.calcuttametroapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ActivityStations extends Activity {
	MediaPlayer mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stations);
		 mp = MediaPlayer.create(getBaseContext(),R.raw.selectstationssound);
		  mp.start();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_stations, menu);
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

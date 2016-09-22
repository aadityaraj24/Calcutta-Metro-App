package com.example.calcuttametroapp;



import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {
	MediaPlayer mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 mp = MediaPlayer.create(getBaseContext(),R.raw.welcomesound);
        mp.start();
		new Handler().postDelayed(new Runnable()
		{
			@Override
			public void run()
			{
				Intent i=new Intent(MainActivity.this,ActivityHomePage.class);
				startActivity(i);
				MainActivity.this.finish();
			}
			}, 5000);
		}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

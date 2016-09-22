package com.example.calcuttametroapp;

import java.text.DecimalFormat;



import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class ActivityTravelInfo extends Activity implements OnItemSelectedListener {
	MediaPlayer mp;
	Spinner source;
	 Spinner destination;
	 TextView time;
	 TextView fare;
	 TextView dist;
	 int temfare;
	 double resTime;
	 int resMin;
	 Button btn;
	 Double absRes;
	
	 private double distance[]={0,2.088,4.239,5.864,6.792,7.793,8.559,9.596,10.193,10.898,11.706,12.433,13.449,14.297,15.33,15.951,17.194,18.538,20.352,22.074,23.127,24.372,25.647,27.223};
     private double tim_pos[]={0,360,540,660,780,900,1020,1140,1260,1320,1440,1560,1620,1740,1860,1980,2100,2280,2520,2700,2820,2940,3060,3300};
	 private double tim_neg[]={ 3300,2940,2640,2460,2340,2220,2100,1980,1860,1800,1680,1620,1500,1380,1260,1140,1020,900,720,540,420,300,180,0};
  @Override
  protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_travel_info);
   mp = MediaPlayer.create(getBaseContext(),R.raw.sourcesound);
  mp.start();
  
  dist = (TextView) findViewById(R.id.distRes);
  source = (Spinner) findViewById(R.id.sourceSpin);
  fare = (TextView) findViewById(R.id.fareRes);
  time = (TextView) findViewById(R.id.dur);
  destination = (Spinner) findViewById(R.id.desSpin);
  String[] list=getResources().getStringArray(R.array.countries);
  ArrayAdapter<String> adapter_state_source = new ArrayAdapter<String>(this,
    R.layout.spinner_item,R.id.txt1,list);
  
  source.setAdapter(adapter_state_source);
  source.setOnItemSelectedListener(ActivityTravelInfo.this);
  ArrayAdapter<String> adapter_state_dest = new ArrayAdapter<String>(this,
		    R.layout.spinner_item,R.id.txt,list);
		 
		  destination.setAdapter(adapter_state_dest);
		  destination.setOnItemSelectedListener(ActivityTravelInfo.this);

  }

  public void onItemSelected(AdapterView<?> parent, View view, int position,
   long id) {
	  String selState =(String) source.getSelectedItem();
	  String selDes=(String) destination.getSelectedItem();
	  int numberSource =source
	          .getSelectedItemPosition();
	  int numberDestination =destination
	          .getSelectedItemPosition();
	  
	  double resDistance=distance[numberDestination]-distance[numberSource];
	  if((numberSource-numberDestination)<0)
	  resTime=Math.abs(tim_pos[numberDestination]-tim_pos[numberSource]);
	  else if((numberSource-numberDestination)>0)
		  resTime=Math.abs(tim_neg[numberDestination]-tim_neg[numberSource]);
	  absRes=Math.abs(resDistance);
	  int min=(int)resTime/60;
	  
	  if(min>=0 && min<=9)
	  {
	  time.setText("00:0"+min+":00"); 
	  }
	  
	  else 
		  time.setText("00:"+min+":00");
	  dist.setText(""+new DecimalFormat("##.##").format(Math.abs(resDistance))+" "+"Kms");
	  if(absRes==0)
	  {
		  temfare=0;
	  }
	  else if(absRes<=5)
	  {
		   temfare=5;
	  }
	  else if(absRes>5 && absRes<=10)
	  {
		  temfare=10;
	  }
	  else if(absRes>10 && absRes<=20)
	  {
		  temfare=15;
	  }
	  else if(absRes>20 && absRes<=25)
	  {
		  temfare=20;
	  }
	  else if(absRes>25)
	  {
		  temfare=25;
	  }
	  
		  
		  fare.setText(""+temfare+" "+"Rs.");
	      
	  
	  
	  
	 }
 
  @Override
 public void onNothingSelected(AdapterView<?> arg0) {
  // TODO Auto-generated method stub

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
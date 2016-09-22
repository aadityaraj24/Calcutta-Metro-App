package com.example.calcuttametroapp;


import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;



import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class ActivityTrainTime extends Activity implements OnItemSelectedListener {
	MediaPlayer mp;
	Spinner source;
	 Spinner destination;
	 TextView time;
	 TextView fare;
	 TextView dist;
	 Button btn;
	 int i,j,k;
	 int timeMin;
	 
	  String weekDay;
	 
	 
	 private double tim_pos[]={0,360,540,660,780,900,1020,1140,1260,1320,1440,1560,1620,1740,1860,1980,2100,2280,2520,2700,2820,2940,3060,3300};
     private double tim_neg[]={ 3300,2940,2640,2460,2340,2220,2100,1980,1860,1800,1680,1620,1500,1380,1260,1140,1020,900,720,540,420,300,180,0};
	 int interval_kavi[]={405,420,430,440,450,460,470,480,490,500,510,520,530,540,546,552,558,564,570,576,582,588,594,599,604,609,614,619,624,629,634,639,644,650,656,662,668,674,680,686,692,698,704,710,716,722,728,734,740,746,752,758,764,771,778,785,792,799,806,813,820,827,834,841,848,855,862,869,876,883,890,897,904,911,918,925,932,939,946,953,960,966,972,978,984,990,996,1002,1008,1014,1020,1025,1030,1035,1040,1045,1050,1055,1060,1065,1070,1075,1080,1086,1092,1098,1104,1110,1116,1122,1128,1134,1140,1146,1152,1158,1164,1170,1178,1186,1194,1202,1210,1218,1226,1234,1242,1250,1260,1270,1280,1290,1300,1315};
     int interval_kavi_sun[]={590,610,628,643,658,673,688,703,718,733,748,763,778,793,808,823,838,853,868,883,898,913,928,943,958,973,988,1003,1018,1028,1038,1048,1058,1068,1078,1088,1098,1108,1118,1128,1138,1148,1158,1168,1178,1188,1198,1213,1228,1243,1260,1275,1290,1305,1315};
     int interval_kavi_sat[]={405,420,435,450,460,470,480,490,500,510,520,530,540,547,554,561,568,575,582,589,596,603,610,617,624,631,638,645,652,659,666,673,680,687,694,701,708,715,722,730,738,746,754,762,770,778,786,794,802,810,818,826,834,842,850,858,866,874,882,890,898,906,914,922,930,938,946,954,962,970,978,986,994,1002,1010,1018,1025,1032,1039,1046,1053,1060,1067,1074,1081,1088,1095,1102,1109,1116,1123,1130,1137,1144,1151,1158,1165,1172,1179,1186,1193,1200,1210,1220,1230,1240,1250,1260,1270,1285,1300,1315};
     int interval_dum[]={405,420,430,440,450,460,470,480,490,500,510,518,526,534,540,545,550,555,560,565,570,575,580,585,590,595,601,607,613,619,625,631,637,643,649,655,660,665,670,675,680,685,690,695,700,705,710,716,722,728,734,740,746,752,758,764,771,778,785,792,799,806,813,820,827,834,841,848,855,862,869,876,883,890,897,904,911,918,925,932,939,946,953,960,966,972,978,984,990,996,1002,1008,1014,1020,1026,1032,1038,1044,1050,1056,1062,1068,1074,1080,1085,1090,1095,1100,1105,1110,1115,1120,1125,1130,1135,1140,1146,1152,1158,1164,1170,1178,1186,1194,1202,1210,1218,1226,1234,1242,1250,1260,1270,1280,1290,1300,1315};
     int interval_dum_sun[]={590,610,630,647,664,678,692,707,722,737,752,767,782,797,812,827,842,857,872,887,902,917,932,947,962,977,992,1007,1022,1032,1042,1052,1062,1072,1082,1092,1102,1112,1122,1132,1142,1152,1162,1172,1182,1192,1202,1217,1232,1247,1260,1275,1290,1305,1315};
     
     int interval_dum_sat[]={405,420,435,450,460,470,480,490,500,510,520,530,540,547,554,561,568,575,582,589,596,603,610,617,624,631,638,645,652,659,666,673,680,687,694,701,708,715,722,730,738,746,754,762,770,778,786,794,802,810,818,826,834,842,850,858,866,874,882,890,898,906,914,922,930,938,946,954,962,970,978,986,994,1002,1010,1018,1025,1032,1039,1046,1053,1060,1067,1074,1081,1088,1095,1102,1109,1116,1123,1130,1137,1144,1151,1158,1165,1172,1179,1186,1193,1200,1210,1220,1230,1240,1250,1260,1270,1285,1300,1315};
     
     @Override
  protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  
  setContentView(R.layout.activity_train_time);
  mp = MediaPlayer.create(getBaseContext(),R.raw.traintimesound);
  mp.start();
  source = (Spinner) findViewById(R.id.sourceSpin);
  btn=(Button) findViewById(R.id.Button01);
  time = (TextView) findViewById(R.id.TextView04);
  destination = (Spinner) findViewById(R.id.desSpin);
  dist=(TextView) findViewById(R.id.TextView01);
  destination = (Spinner) findViewById(R.id.desSpin);
  String[] list=getResources().getStringArray(R.array.countries);
  ArrayAdapter<String> adapter_state_source = new ArrayAdapter<String>(this,
    R.layout.spinner_item,R.id.txt1,list);
  
  source.setAdapter(adapter_state_source);
  source.setOnItemSelectedListener(ActivityTrainTime.this);
  ArrayAdapter<String> adapter_state_dest = new ArrayAdapter<String>(this,
		    R.layout.spinner_item,R.id.txt,list);
		 
		  destination.setAdapter(adapter_state_dest);
		  destination.setOnItemSelectedListener(ActivityTrainTime.this);
				  
				 
                   Calendar c=Calendar.getInstance();
				 
				  int hours=c.get(Calendar.HOUR);
				  int minutes=c.get(Calendar.MINUTE);
				  int seconds=c.get(Calendar.SECOND);
				  
				  if(c.get(Calendar.AM_PM)==0)
				  {timeMin=(hours*60)+minutes;
				 
				  
				  }
				  else
				  {  timeMin=((hours+12)*60)+minutes;
					  
					
				  }  
				  btn.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Calendar c=Calendar.getInstance();
						 SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.US);

						  
						  weekDay = dayFormat.format(c.getTime());
						  int hours=c.get(Calendar.HOUR);
						  int minutes=c.get(Calendar.MINUTE);
						  int seconds=c.get(Calendar.SECOND);
						  if(c.get(Calendar.AM_PM)==0)
						  {timeMin=(hours*60)+minutes;
						 
						  
						  
						  }
							  else
							  {timeMin=((hours+12)*60)+minutes;
							  
						  
							  }
						  int numberSource =source
						          .getSelectedItemPosition();
						  int numberDestination =destination
						          .getSelectedItemPosition();
						  j=(int) ((tim_pos[numberSource]-tim_pos[1])/60);
						  k=(int) ((tim_neg[numberSource]-tim_neg[23])/60);
						 
						
						  if(numberSource-numberDestination<0)
						  {
							 if(weekDay.equals("Sunday"))
							 {
						  for( i=0;(interval_dum_sun[i]+j)<timeMin;i++)
						  {
							  continue;
						  }
						  int tym=(interval_dum_sun[i]+j);
						  int hrs=tym/60;
						  int mnt=tym%60;
						  if(mnt>=0 && mnt<=9)
						  {
							  dist.setText(""+hrs +":0"+mnt); 
						  }
						  
						  else 
							  dist.setText(""+hrs +":"+mnt);
						  }
							 else if(weekDay.equals("Saturday"))
							 {
								 for( i=0;(interval_dum_sat[i]+j)<timeMin;i++)
								  {
									  continue;
								  }
								  int tym=(interval_dum_sat[i]+j);
								  int hrs=tym/60;
								  int mnt=tym%60;
								  if(mnt>=0 && mnt<=9)
								  {
									  dist.setText(""+hrs +":0"+mnt); 
								  }
								  
								  else 
									  dist.setText(""+hrs +":"+mnt);
							 }
							 else
							 {
								 for( i=0;(interval_dum[i]+j)<timeMin;i++)
								  {
									  continue;
								  }
								  int tym=(interval_dum[i]+j);
								  int hrs=tym/60;
								  int mnt=tym%60;
								  if(mnt>=0 && mnt<=9)
								  {
									  dist.setText(""+hrs +":0"+mnt); 
								  }
								  
								  else 
									  dist.setText(""+hrs +":"+mnt);
							 }
								 
						  }
						  
						  else if((numberSource-numberDestination)>0)
						  {
							  if(weekDay.equals("Sunday"))
							  {
							  for(i=0;(interval_kavi_sun[i]+k)<timeMin;i++)
							  {
								  continue;
							  }
							  int tym=(interval_kavi_sun[i]+k);
							  int hrs=tym/60;
							  int mnt=tym%60;
							  if(mnt>=0 && mnt<=9)
							  {
								  dist.setText(""+hrs +":0"+mnt); 
							  }
							  
							  else 
								  dist.setText(""+hrs +":"+mnt);
						  }
							  else if(weekDay.equals("Saturday"))
							  {
							  for(i=0;(interval_kavi_sat[i]+k)<timeMin;i++)
							  {
								  continue;
							  }
							  int tym=(interval_kavi_sat[i]+k);
							  int hrs=tym/60;
							  int mnt=tym%60;
							  if(mnt>=0 && mnt<=9)
							  {
								  dist.setText(""+hrs +":0"+mnt); 
							  }
							  
							  else 
								  dist.setText(""+hrs +":"+mnt);
						  }
							  else
							  {
							  for(i=0;(interval_kavi[i]+k)<timeMin;i++)
							  {
								  continue;
							  }
							  int tym=(interval_kavi[i]+k);
							  int hrs=tym/60;
							  int mnt=tym%60;
							  if(mnt>=0 && mnt<=9)
							  {
								  dist.setText(""+hrs +":0"+mnt); 
							  }
							  
							  else 
								  dist.setText(""+hrs +":"+mnt);
						  }}
						  else
							  dist.setText("--:--");
					}
				});
  }

  public void onItemSelected(AdapterView<?> parent, View view, int position,
   long id) {
	  String selState =(String) source.getSelectedItem();
	  String selDes=(String) destination.getSelectedItem();
	
	  SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.US);

	  Calendar c = Calendar.getInstance();
	  weekDay = dayFormat.format(c.getTime());
	  
	  int hours=c.get(Calendar.HOUR);
	  int minutes=c.get(Calendar.MINUTE);
	  int seconds=c.get(Calendar.SECOND);
	  if(c.get(Calendar.AM_PM)==0)
	  {timeMin=(hours*60)+minutes;
	 
	  
	  
	  }
		  else
		  {timeMin=((hours+12)*60)+minutes;
		  
	  
		  }
	  int numberSource =source
	          .getSelectedItemPosition();
	  int numberDestination =destination
	          .getSelectedItemPosition();
	  j=(int) ((tim_pos[numberSource]-tim_pos[1])/60);
	  k=(int) ((tim_neg[numberSource]-tim_neg[23])/60);
	 
	
	  if(numberSource-numberDestination<0)
	  {
		 if(weekDay.equals("Sunday"))
		 {
	  for( i=0;(interval_dum_sun[i]+j)<timeMin;i++)
	  {
		  continue;
	  }
	  int tym=(interval_dum_sun[i]+j);
	  int hrs=tym/60;
	  int mnt=tym%60;
	  if(mnt>=0 && mnt<=9)
	  {
		  dist.setText(""+hrs +":0"+mnt); 
	  }
	  
	  else 
		  dist.setText(""+hrs +":"+mnt);
	  }
		 else if(weekDay.equals("Saturday"))
		 {
			 for( i=0;(interval_dum_sat[i]+j)<timeMin;i++)
			  {
				  continue;
			  }
			  int tym=(interval_dum_sat[i]+j);
			  int hrs=tym/60;
			  int mnt=tym%60;
			  if(mnt>=0 && mnt<=9)
			  {
				  dist.setText(""+hrs +":0"+mnt); 
			  }
			  
			  else 
				  dist.setText(""+hrs +":"+mnt);
		 }
		 else
		 {
			 for( i=0;(interval_dum[i]+j)<timeMin;i++)
			  {
				  continue;
			  }
			  int tym=(interval_dum[i]+j);
			  int hrs=tym/60;
			  int mnt=tym%60;
			  if(mnt>=0 && mnt<=9)
			  {
				  dist.setText(""+hrs +":0"+mnt); 
			  }
			  
			  else 
				  dist.setText(""+hrs +":"+mnt);
		 }
			 
	  }
	  
	  else if((numberSource-numberDestination)>0)
	  {
		  if(weekDay.equals("Sunday"))
		  {
		  for(i=0;(interval_kavi_sun[i]+k)<timeMin;i++)
		  {
			  continue;
		  }
		  int tym=(interval_kavi_sun[i]+k);
		  int hrs=tym/60;
		  int mnt=tym%60;
		  if(mnt>=0 && mnt<=9)
		  {
			  dist.setText(""+hrs +":0"+mnt); 
		  }
		  
		  else 
			  dist.setText(""+hrs +":"+mnt);
	  }
		  else if(weekDay.equals("Saturday"))
		  {
		  for(i=0;(interval_kavi_sat[i]+k)<timeMin;i++)
		  {
			  continue;
		  }
		  int tym=(interval_kavi_sat[i]+k);
		  int hrs=tym/60;
		  int mnt=tym%60;
		  if(mnt>=0 && mnt<=9)
		  {
			  dist.setText(""+hrs +":0"+mnt); 
		  }
		  
		  else 
			  dist.setText(""+hrs +":"+mnt);
	  }
		  else
		  {
		  for(i=0;(interval_kavi[i]+k)<timeMin;i++)
		  {
			  continue;
		  }
		  int tym=(interval_kavi[i]+k);
		  int hrs=tym/60;
		  int mnt=tym%60;
		  if(mnt>=0 && mnt<=9)
		  {
			  dist.setText(""+hrs +":0"+mnt); 
		  }
		  
		  else 
			  dist.setText(""+hrs +":"+mnt);
	  }
  }
	  else
		  dist.setText("--:--");

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
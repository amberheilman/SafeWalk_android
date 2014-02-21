package com.tatertots.safewalk;

import android.location.LocationListener;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class RequestActivity extends Activity {
	
	private TextView myLocation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_request);
		
		myLocation = (TextView)findViewById(R.id.location);
		
		//listens for changes in location
		LocationListener myLocationListener = new GPSTracker(this.getBaseContext());
		
		//set the location to the lat and long
		myLocation.setText(Double.toString(((GPSTracker) myLocationListener).getLatitude()) +
						   Double.toString(((GPSTracker) myLocationListener).getLongitude()));
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.request, menu);
		return true;
	}

}

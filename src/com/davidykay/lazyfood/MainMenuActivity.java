package com.davidykay.lazyfood;

import java.math.BigDecimal;

import roboguice.activity.RoboActivity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainMenuActivity extends RoboActivity implements SensorEventListener {

  private static final float SHAKE_THRESHOLD = new BigDecimal("1E-5").floatValue();
  private SensorManager mSensorManager;
  private long mLastUpdate;
  private float mLastX;
  private float mLastY;
  private float mLastZ;

  ////////////////////////////////////////
  // Activity Lifecycle
  ////////////////////////////////////////

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.main);

    mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
  }

  @Override
  public void onStart() {
    super.onStart();

    //mSensorManager.registerListener(this,
    //                                mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
    //                                SensorManager.SENSOR_DELAY_NORMAL);

  }

  @Override
  public void onStop() {
    super.onStop();

    //mSensorManager.unregisterListener(this);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.main_menu, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle item selection
    switch (item.getItemId()) {
      case R.id.options:
        launchOptions();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }

  ////////////////////////////////////////
  // SensorEventListener
  ////////////////////////////////////////

  @Override
  public void onSensorChanged(SensorEvent event) {
    if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
      long curTime = System.currentTimeMillis();
      // only allow one update every 100ms.
      if ((curTime - mLastUpdate) > 100) {
        long diffTime = (curTime - mLastUpdate);
        mLastUpdate = curTime;

        float[] values = event.values;
        float x = values[0];
        float y = values[1];
        float z = values[2];

        float sum = x + y + z;
        float lastSum = mLastX + mLastY + mLastZ;
        float diff = sum - lastSum;

        float speed = Math.abs(diff / (diffTime * 10000));

        String speedString = "speed: " + speed;

        if (speed > SHAKE_THRESHOLD) {

          onShakeDetected();
          String logMessage = "SHAKE detected w/ " + speedString;

          Log.d("sensor", logMessage);
          Toast.makeText(this, logMessage, Toast.LENGTH_SHORT).show();


        } else {
          String logMessage = "movement under threshold w/ " + speedString;

          Log.v("sensor", logMessage);
        }
        mLastX = x;
        mLastY = y;
        mLastZ = z;
      }
    }
  }

  @Override
  public void onAccuracyChanged(Sensor arg0, int arg1) {
    // TODO Auto-generated method stub

  }

  public void onManualClick(View v) {
    // Go to view our favorite dishes
    Intent i = new Intent(this, ItemListActivity.class);
    startActivity(i);
  }

  public void onAutomaticClick(View v) {
    // Pick one and skip straight to ordering
    Intent i = new Intent(this, RandomOrderActivity.class);
    startActivity(i);
  }

  public void onShakeDetected() {
    Intent i = new Intent(this, RandomOrderActivity.class);
    startActivity(i);
  }

  ////////////////////////////////////////
  // Navigation
  ////////////////////////////////////////

  private void launchOptions() {
    Intent i = new Intent(this, OptionsActivity.class);
    startActivity(i);
  }

}

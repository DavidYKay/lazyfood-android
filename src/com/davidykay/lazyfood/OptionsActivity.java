package com.davidykay.lazyfood;

import java.util.List;

import roboguice.activity.RoboPreferenceActivity;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Button;

//@ContentView(R.layout.options)
public class OptionsActivity extends RoboPreferenceActivity {

  ////////////////////////////////////////
  // Activity Lifecycle
  ////////////////////////////////////////


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    addPreferencesFromResource(R.xml.preferences);
  }



}

package com.davidykay.lazyfood;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import android.os.Bundle;
import android.view.View;

@ContentView(R.layout.meal_edit)
public class MealEditActivity extends RoboActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  }


  public void onSaveClick(View v) {

  }

}


package com.davidykay.lazyfood;

import roboguice.activity.RoboActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RandomOrderActivity extends RoboActivity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.random_order);
  }



  public void onOrderClick(View v) {
    // Place our order, clear the stack

    Intent i = new Intent(this, ConfirmationActivity.class);

    startActivity(i);
  }


}

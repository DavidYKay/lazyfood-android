
package com.davidykay.lazyfood;

import roboguice.activity.RoboActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class ConfirmationActivity extends RoboActivity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.confirmation);
  }

  public void onDoneClick(View v) {
    String logMessage = "All done";

    Log.d("done", logMessage);
    Toast.makeText(this, logMessage, Toast.LENGTH_SHORT).show();

    // We're all done!
    Intent intent = new Intent(this, ShakeActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivity(intent);
  }

}

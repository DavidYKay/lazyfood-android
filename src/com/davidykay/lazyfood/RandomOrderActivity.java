
package com.davidykay.lazyfood;

import roboguice.activity.RoboActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.davidykay.lazyfood.dummy.DummyContent;
import com.davidykay.lazyfood.iface.FailureCallback;
import com.davidykay.lazyfood.iface.SuccessCallback;
import com.davidykay.lazyfood.network.NetworkHelper;
import com.google.inject.Inject;

public class RandomOrderActivity extends RoboActivity {

  private Context mContext = this;
  @Inject private NetworkHelper mNetworkHelper;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.random_order);

    beginOrder();
  }

  public void beginOrder() {
    Toast.makeText(this, "Ordering...", Toast.LENGTH_SHORT).show();

    // mNetworkHelper.orderTrayFromAPI(mFragment.getItem().getId());
    mNetworkHelper.orderTrayFromAPIAsync(
        DummyContent.getRandomId(),
        new SuccessCallback() {
          @Override
          public void onSuccess() {
            Toast.makeText(mContext, "Success!", Toast.LENGTH_SHORT).show();

            advanceToConfirm();
          }
        },
        new FailureCallback() {



          @Override
          public void onFailure(Exception ex) {
            Toast.makeText(mContext, "Failure!", Toast.LENGTH_SHORT).show();

          }
        });
  }


  public void onOrderClick(View v) {
    // Place our order, clear the stack
  }

  public void advanceToConfirm() {
    Intent i = new Intent(this, ConfirmationActivity.class);
    startActivity(i);
  }

}

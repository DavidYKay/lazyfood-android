package com.davidykay.lazyfood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ItemListActivity extends FragmentActivity
implements ItemListFragment.Callbacks {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_item_list);

    // TODO: If exposing deep links into your app, handle intents here.

  }

  /**
   * Callback method from {@link ItemListFragment.Callbacks}
   * indicating that the item with the given ID was selected.
   */
  @Override
  public void onItemSelected(String id) {

    //  simply start the detail activity for the selected item ID.
    Intent detailIntent = new Intent(this, ItemDetailActivity.class);
    detailIntent.putExtra(ItemDetailFragment.ARG_ITEM_ID, id);
    startActivity(detailIntent);

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.manual_order, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle item selection
    switch (item.getItemId()) {
      case R.id.add_meal:
        addMeal();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }

  ////////////////////////////////////////
  // Navigation
  ////////////////////////////////////////

  private void addMeal() {
    Intent i = new Intent(this, MealEditActivity.class);
    startActivity(i);
  }

}

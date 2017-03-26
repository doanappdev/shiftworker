package com.example.doan.shiftworker.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.inputmethod.InputMethodManager;
import butterknife.ButterKnife;
import com.example.doan.shiftworker.R;
import com.example.doan.shiftworker.ShiftWorkerApp;

import com.example.doan.shiftworker.dagger.component.DaggerUiComponent;
import com.example.doan.shiftworker.dagger.component.UiComponent;
import javax.inject.Inject;

/**
 * Created by doanappdev@gmail.com on 25/3/17.
 */

public class BaseActivity extends AppCompatActivity implements BaseView {

  @Inject protected SharedPreferences prefs;

  protected UiComponent component() {
    //need to comment this when adding new activity/presenter to UIComponent.
    //then rebuild the app so the dependency is added to the DaggerUiComponent
    //you can check the file to see if your activity/layout/presenter has been added
    return DaggerUiComponent.builder()
        .appComponent(ShiftWorkerApp.of(this).component())
        .build();
    //return null;
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
  }

  @Override protected void onPostCreate(Bundle savedInstanceState) {
    initToolbar(-1);
    ButterKnife.bind(this);
    super.onPostCreate(savedInstanceState);
  }

  @Override protected void onResume() {super.onResume();}

  @Override protected void onStop () {
    super.onStop();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
  }

  /** BaseView methods **/
  @Override public void hideKeyboard() {
    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    imm.hideSoftInputFromWindow(findViewById(android.R.id.content).getWindowToken(), 0);
  }

  @Override public void showProgressDialog(String message) {
  }

  @Override
  public void hideProgressDialog() {

  }

  /** Toolbar **/
  private void initToolbar(int colorId) {
    //Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
    //if(toolbar != null) setSupportActionBar(toolbar);
    ////toolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white);
    //ActionBar actionBar = getSupportActionBar();
    //if (actionBar != null) {
    //  if (colorId != -1 && colorId != Color.TRANSPARENT) {
    //    actionBar.setBackgroundDrawable(new ColorDrawable(colorId));
    //  }
    //  actionBar.setDisplayHomeAsUpEnabled(true);
    //}
  }

  protected void setToolbarTitle(String title) {
    //setToolbarTitle(title);
    if (getSupportActionBar() != null) getSupportActionBar().setTitle(title);
  }

  protected void setToolbarIcon(int iconResource) {
    //setToolbarIcon(iconResource);
    if(getSupportActionBar() != null) {
      getSupportActionBar().setDisplayShowHomeEnabled(true);
      getSupportActionBar().setHomeAsUpIndicator(iconResource);
    }
  }

  /**
   * Activity related methods
   */

  public static void launch(Activity fromActivity, Class<?> toActivity) {
    Intent intent = new Intent(fromActivity, toActivity);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NO_ANIMATION);
    ActivityCompat.startActivity(fromActivity, intent, null);
  }

  /**
   * Interface method used by sub view class to close out the activity
   */
  public void finishActivity() {finish();}
}


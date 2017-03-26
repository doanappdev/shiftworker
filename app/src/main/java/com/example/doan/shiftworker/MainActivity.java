package com.example.doan.shiftworker;

import android.os.Bundle;
import android.util.Log;
import com.example.doan.data.entities.Business;
import com.example.doan.shiftworker.base.BaseActivity;
import com.example.doan.shiftworker.interactor.GetBusinessInteractor;
import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainPresenter.View {

  private static final String TAG = MainActivity.class.getSimpleName();

  @Inject MainPresenter presenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    component().inject(this);

    //Log.d(TAG, "getShiftTime = " + getShiftInteractor.getShiftTime());
  }

  @Override protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    presenter.attachView(this);
    presenter.initData();
  }

  @Override public void printBusinessInfo(Business business) {
    Log.d(TAG, "business name : " + business.name);
    Log.d(TAG, "business logo : " + business.logo);
  }
}

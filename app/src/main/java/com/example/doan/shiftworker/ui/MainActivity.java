package com.example.doan.shiftworker.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.OnClick;
import com.bumptech.glide.Glide;
import com.example.doan.data.entities.Business;
import com.example.doan.data.entities.Shift;
import com.example.doan.shiftworker.R;
import com.example.doan.shiftworker.base.BaseActivity;
import java.util.List;
import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainPresenter.View {

  private static final String TAG = MainActivity.class.getSimpleName();

  @BindView(R.id.start_shift_btn) Button startShiftBtn;
  @BindView(R.id.end_shift_btn) Button endShiftBtn;
  @BindView(R.id.display_shifts_btn) Button displayShiftsBtn;
  @BindView(R.id.logo_iv) ImageView logoIv;

  @Inject MainPresenter presenter;

  private boolean isStartShift;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    component().inject(this);
  }

  @Override protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    presenter.attachView(this);
    presenter.initData();
  }

  @OnClick(R.id.start_shift_btn) void onStartShift() {
    presenter.onStartShift();
  }

  @OnClick(R.id.end_shift_btn) void onEndShift() {
    presenter.onEndShift();
    enableButton(false);
  }

  @OnClick(R.id.display_shifts_btn) void onDisplayShifts() {
    presenter.onDisplayShifts();
    enableButton(true);
  }

  @Override public void printBusinessInfo(Business business) {
    Log.d(TAG, "business name : " + business.name);
    Log.d(TAG, "business logo : " + business.logo);
    Glide.with(this).load(business.logo).into(logoIv);
  }

  @Override public void displayShiftList(List<Shift> shifts) {

  }

  private void enableButton(boolean isEnabled) {
    startShiftBtn.setVisibility(isEnabled ? View.VISIBLE : View.GONE);
  }
}

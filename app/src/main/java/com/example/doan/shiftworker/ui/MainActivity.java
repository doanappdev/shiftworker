package com.example.doan.shiftworker.ui;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import butterknife.BindColor;
import butterknife.BindView;
import butterknife.OnClick;
import com.bumptech.glide.Glide;
import com.example.doan.data.entities.Business;
import com.example.doan.data.entities.Shift;
import com.example.doan.shiftworker.R;
import com.example.doan.shiftworker.base.BaseActivity;
import java.util.List;
import javax.inject.Inject;
import org.parceler.Parcels;

public class MainActivity extends BaseActivity implements MainPresenter.View,
    ShiftAdapter.OnShiftItemClick {

  private static final String TAG = MainActivity.class.getSimpleName();

  @BindView(R.id.main_container) CoordinatorLayout mainContainer;
  @BindView(R.id.start_shift_btn) Button startShiftBtn;
  @BindView(R.id.end_shift_btn) Button endShiftBtn;
  @BindView(R.id.display_shifts_btn) Button displayShiftsBtn;
  @BindView(R.id.logo_iv) ImageView logoIv;
  @BindView(R.id.shifts_rv) RecyclerView shiftsRv;

  @BindColor(R.color.colorPrimary) int primaryColour;

  @Inject MainPresenter presenter;

  private ShiftAdapter adapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    component().inject(this);
  }

  @Override protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    presenter.attachView(this);
    presenter.initData();
    endShiftBtn.setEnabled(false);
    initToolbar(primaryColour, false);
  }

  @OnClick(R.id.start_shift_btn) void onStartShift() {
    presenter.onStartShift();
    displaySnackBar(mainContainer, "Shift has started");
    startShiftBtn.setEnabled(false);
    endShiftBtn.setEnabled(true);
  }

  @OnClick(R.id.end_shift_btn) void onEndShift() {
    presenter.onEndShift();
    displaySnackBar(mainContainer, "Shift has ended");
    startShiftBtn.setEnabled(true);
    endShiftBtn.setEnabled(false);
  }

  @OnClick(R.id.display_shifts_btn) void onDisplayShifts() {
    presenter.onDisplayShifts();
  }

  @Override public void printBusinessInfo(Business business) {
    Log.d(TAG, "business name : " + business.name);
    Log.d(TAG, "business logo : " + business.logo);
    setToolbarTitle(business.name);
    Glide.with(this).load(business.logo).into(logoIv);
  }

  @Override public void displayShiftList(List<Shift> shifts) {
    initAdapter(shifts);
  }

  private void initAdapter(List<Shift> shifts) {
    if (adapter == null) {
      adapter = new ShiftAdapter(this, shifts, this);
      shiftsRv.setLayoutManager(new LinearLayoutManager(this));
      shiftsRv.setAdapter(adapter);
    } else {
      adapter.notifyDataSetChanged();
    }
  }

  @Override public void onShiftItemClick(Shift shift) {
    Bundle bundle = new Bundle();
    bundle.putParcelable(getString(R.string.key_shift), Parcels.wrap(shift));
    launch(this, ShiftDetailActivity.class, bundle);
  }
}

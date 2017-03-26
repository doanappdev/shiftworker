package com.example.doan.shiftworker.ui;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.example.doan.data.entities.Shift;
import com.example.doan.shiftworker.R;
import com.example.doan.shiftworker.base.BaseActivity;
import javax.inject.Inject;
import org.parceler.Parcels;

public class ShiftDetailActivity extends BaseActivity implements ShiftDetailPresenter.View {

  @BindView(R.id.icon_iv) ImageView iconImgView;
  @BindView(R.id.id_tv) TextView idTxt;
  @BindView(R.id.start_date_time_tv) TextView startDateTimeTxt;
  @BindView(R.id.end_date_time_tv) TextView endDateTimeTxt;
  @BindView(R.id.start_lat_tv) TextView startLatTxt;
  @BindView(R.id.start_lng_tv) TextView startLngTxt;
  @BindView(R.id.end_lat_tv) TextView endLatTxt;
  @BindView(R.id.end_lng_tv) TextView endLngTxt;

  @Inject ShiftDetailPresenter presenter;

  private Shift shift;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_shift_detail);
    component().inject(this);
    shift = Parcels.unwrap(getIntent().getParcelableExtra(getString(R.string.key_shift)));
  }

  @Override protected void onPostCreate(@Nullable Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    presenter.attachView(this);
    if (shift != null) {
      presenter.initData(shift);
    }
  }

  @Override public void setId(int id) {
    idTxt.setText(String.valueOf(id));
  }

  @Override public void setStartDateTime(String startDateTime) {
    startDateTimeTxt.setText(startDateTime);
  }

  @Override public void setEndDateTime(String endDateTime) {
    endDateTimeTxt.setText(endDateTime);
  }

  @Override public void setStartPosition(String lat, String lng) {
    startLatTxt.setText(lat);
    startLngTxt.setText(lng);
  }

  @Override public void setEndPosition(String lat, String lng) {
    endLatTxt.setText(lat);
    endLngTxt.setText(lng);
  }

  @Override public void setImage(String imageUrl) {
    Glide.with(this).load(imageUrl).into(iconImgView);
  }
}

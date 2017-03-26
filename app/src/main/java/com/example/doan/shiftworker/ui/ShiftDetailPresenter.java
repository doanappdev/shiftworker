package com.example.doan.shiftworker.ui;

import com.example.doan.data.entities.Shift;
import com.example.doan.shiftworker.base.BasePresenter;
import com.example.doan.shiftworker.base.BaseView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.inject.Inject;

/**
 * Created by doanappdev@gmail.com on 26/3/17.
 */

public class ShiftDetailPresenter extends BasePresenter<ShiftDetailPresenter.View> {

  interface View extends BaseView {
    void setImage(String imageUrl);
    void setId(int id);
    void setStartDateTime(String startDateTime);
    void setEndDateTime(String endDateTime);
    void setStartPosition(String lat, String lng);
    void setEndPosition(String lat, String lng);
  }

  @Inject public ShiftDetailPresenter() {
  }

  public void initData(Shift shift) {
    view.setImage(shift.getImage());
    view.setId(shift.getId());
    view.setStartDateTime(getFormattedDateTime(shift.getStartDateTime()));
    view.setEndDateTime(getFormattedDateTime(shift.getEndDateTime()));
    view.setStartPosition(shift.getStartLatitude(), shift.getStartLongitude());
    view.setEndPosition(shift.getEndLatitude(), shift.getEndLongitude());
  }

  private String getFormattedDateTime(Date dateTime) {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
    return formatter.format(dateTime);
  }
}

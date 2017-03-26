package com.example.doan.data.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by doanappdev@gmail.com on 26/3/17.
 *
 * Sydney : -33.865143, 151.209900
 * Brisbane: -27.470125, 153.021072
 */

public class ShiftInfo {
  private String time;
  private double latitude;
  private double longitude;

  public ShiftInfo() {
  }

  public ShiftInfo(double latitude, double longitude) {
    time = getTimeStamp();
    this.latitude = latitude;
    this.longitude = longitude;
  }

  private String getTimeStamp() {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'", Locale.ENGLISH);
    return df.format(new Date());
  }
}

package com.example.doan.data.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by doanappdev@gmail.com on 26/3/17.
 *
 * Sydney : -33.865143, 151.209900
 */

public class ShiftInfo {
  public String time;
  public double latitude;
  public double longitude;

  public ShiftInfo() {
    //"time": "2017-01-17T06:35:57+00:00", (string, ISO 8601)
    //"latitude": "0.00000", (string)
    //"longitude": "0.00000" (string)

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'", Locale.ENGLISH);
    Date date = new Date();
    String dateTime = df.format(date);
    time = dateTime;
    latitude = -33.865143;
    longitude = 151.209900;
  }
}

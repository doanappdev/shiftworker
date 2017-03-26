package com.example.doan.data.entities;

import java.util.Date;
import org.parceler.Parcel;

/**
 * Created by doanappdev@gmail.com on 26/3/17.
 */
@Parcel
public class Shift {
  protected int id;
  protected Date start;
  protected Date end;
  protected String startLatitude;
  protected String startLongitude;
  protected String endLatitude;
  protected String endLongitude;
  protected String image;

  public int getId() {
    return id;
  }

  public Date getStartDateTime() {return start;}

  public Date getEndDateTime() {return end;}

  public String getStartLatitude() {
    return startLatitude;
  }

  public String getStartLongitude() {
    return startLongitude;
  }

  public String getEndLatitude() {
    return endLatitude;
  }

  public String getEndLongitude() {
    return endLongitude;
  }

  public String getImage() {
    return image;
  }
}



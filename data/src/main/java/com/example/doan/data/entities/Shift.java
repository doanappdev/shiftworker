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
  protected String end;
  protected String startLatitude;
  protected String startLongitude;
  protected String endLatitude;
  protected String endLongitude;
  protected String image;

  public int getId() {
    return id;
  }

  public Date getStart() {return start;}

  public String getEnd() {
    return end;
  }

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



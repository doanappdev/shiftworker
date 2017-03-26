package com.example.doan.data.entities;

/**
 * Created by doanappdev@gmail.com on 26/3/17.
 */

public class Shift {
  private int id;
  private String start;
  private String end;
  private String startLatitude;
  private String startLongitude;
  private String endLatitude;
  private String endLongitude;
  private String image;

  public int getId() {
    return id;
  }

  public String getStart() {
    return start;
  }

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



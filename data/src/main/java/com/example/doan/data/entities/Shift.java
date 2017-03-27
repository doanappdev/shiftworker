package com.example.doan.data.entities;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import java.util.Date;
import org.parceler.Parcel;

/**
 * Created by doanappdev@gmail.com on 26/3/17.
 */
@Parcel
public class Shift extends RealmObject {
  @PrimaryKey
  protected int id;
  protected Date start;
  protected Date end;
  protected String startDateTime;
  protected String endDateTime;
  protected String startLatitude;
  protected String startLongitude;
  protected String endLatitude;
  protected String endLongitude;
  protected String image;

  public int getId() {
    return id;
  }

  public Date getStartDate() {return start;}

  public Date getEndDate() {return end;}

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



  public void setStartDateTime(String startDateTime) {
    this.startDateTime = startDateTime;
  }

  public void setEndDateTime(String endDateTime) {
    this.endDateTime = endDateTime;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setStart(Date start) {
    this.start = start;
  }

  public void setEnd(Date end) {
    this.end = end;
  }

  public void setStartLatitude(String startLatitude) {
    this.startLatitude = startLatitude;
  }

  public void setStartLongitude(String startLongitude) {
    this.startLongitude = startLongitude;
  }

  public void setEndLatitude(String endLatitude) {
    this.endLatitude = endLatitude;
  }

  public void setEndLongitude(String endLongitude) {
    this.endLongitude = endLongitude;
  }

  public void setImage(String image) {
    this.image = image;
  }
}



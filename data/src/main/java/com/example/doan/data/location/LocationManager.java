package com.example.doan.data.location;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

/**
 * Created by doanappdev@gmail.com on 26/3/17.
 */

public class LocationManager implements
    GoogleApiClient.ConnectionCallbacks,
    GoogleApiClient.OnConnectionFailedListener,
    LocationListener {
  private static final String TAG = LocationManager.class.getSimpleName();

  private static final int UPDATE_INTERVAL = 5000;
  private static final int FASTEST_INTERVAL = 2250;

  private GoogleApiClient googleApiClient;
  private Context context;
  private Location location;
  private LocationRequest locationRequest;

  public LocationManager(Context context) {
    this.context = context;
    googleApiClient= new GoogleApiClient.Builder(context)
        .addApi(LocationServices.API)
        .addConnectionCallbacks(this)
        .addOnConnectionFailedListener(this)
        .build();

    googleApiClient.connect();
  }

  @Override public void onConnected(@Nullable Bundle bundle) {
    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
        != PackageManager.PERMISSION_GRANTED
        && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION)
        != PackageManager.PERMISSION_GRANTED) {
      // TODO: Consider calling ActivityCompat#requestPermissions
      return;
    }
    startLocationUpdates();
    location = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
    if(location == null){
      startLocationUpdates();
    }
  }

  @Override public void onConnectionSuspended(int i) {
    Log.d(TAG, "onConnectionSuspended : " + i);
  }

  @Override public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    Log.d(TAG, "onConnectionFailed : " + connectionResult.toString());
  }

  @Override public void onLocationChanged(Location location) {
    //Log.d(TAG, "onLocationChanged: lat =  " + location.getLatitude());
    //Log.d(TAG, "onLocationChanged: lng =  " + location.getLongitude());
  }

  protected void startLocationUpdates() {
    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
        != PackageManager.PERMISSION_GRANTED
        && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION)
        != PackageManager.PERMISSION_GRANTED) {
      //TODO: Consider calling ActivityCompat#requestPermissions
      return;
    }
    //Request location updates
    LocationServices.FusedLocationApi.requestLocationUpdates(
        googleApiClient, getLocationRequest(), this);
  }

  private LocationRequest getLocationRequest() {
    locationRequest = LocationRequest.create()
        .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
        .setInterval(UPDATE_INTERVAL)
        .setFastestInterval(FASTEST_INTERVAL);
    return locationRequest;
  }

  public double getLatitude() {
    if (location != null) {
      return location.getLatitude();
    }
    return 0.00000;
  }

  public double getLongitude() {
    if (location != null) {
      return location.getLongitude();
    }
    return 0.00000;
  }
}

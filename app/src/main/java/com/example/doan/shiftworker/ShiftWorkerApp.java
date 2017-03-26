package com.example.doan.shiftworker;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import com.example.doan.shiftworker.dagger.component.AppComponent;
import com.example.doan.shiftworker.dagger.component.AppComponentBuilder;

/**
 * Created by doanappdev@gmail.com on 25/3/17.
 */

public class ShiftWorkerApp extends Application {

  AppComponent appComponent;

  @Override public void onCreate() {
    super.onCreate();
    appComponent = component();
  }

  @Override protected void attachBaseContext(Context base) {
    super.attachBaseContext(base);
    MultiDex.install(this);
  }

  public AppComponent component() {
    if (appComponent == null) buildComponent(this);
    return appComponent;
  }

  public static ShiftWorkerApp of(Context context) {
    return (ShiftWorkerApp) context.getApplicationContext();
  }

  public void buildComponent(Context context) {
    appComponent = AppComponentBuilder.build(context.getApplicationContext());
  }
}

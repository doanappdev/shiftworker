package com.example.doan.shiftworker.dagger.component;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.doan.data.retrofit.ApiServiceFactory;
import com.example.doan.shiftworker.dagger.module.AppModule;
import com.example.doan.data.dagger.DataModule;
import com.example.doan.shiftworker.interactor.GetBusinessInteractor;
import com.example.doan.shiftworker.interactor.GetShiftInteractor;
import com.google.gson.Gson;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by doanappdev@gmail.com on 25/3/17.
 */

@Singleton
@Component(modules = {
    AppModule.class,
    DataModule.class})
public interface AppComponent {
  /** expose to sub-graph the following objects */
  Gson gson();
  Context getContext();
  SharedPreferences getSharedPreferences();
  //ResourceManager getResourceManager();

  ApiServiceFactory getApiServiceFactory();

  GetBusinessInteractor getBusinessInteractor();
  GetShiftInteractor getShiftInteractor();

}

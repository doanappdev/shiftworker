package com.example.doan.data.dagger;

import android.content.Context;
import com.example.doan.data.RxUtil;
import com.example.doan.data.location.LocationManager;
import com.example.doan.data.retrofit.ApiServiceFactory;
import com.example.doan.data.retrofit.api.BusinessService;
import com.example.doan.data.retrofit.api.ShiftService;
import com.example.doan.data.repository.business.BusinessRepositoryImpl;
import com.google.gson.Gson;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by doanappdev@gmail.com on 25/3/17.
 */

@Module
public class DataModule {

  protected RxUtil rxUtil;

  public DataModule(RxUtil rxUtil) {
    this.rxUtil = rxUtil;
  }

  @Provides @Singleton RxUtil provideRxUtil() {
    return new RxUtil();
  }


  @Provides @Singleton ApiServiceFactory provideApiServiceFactory(Gson gson) {
    return new ApiServiceFactory(gson);
  }

  @Provides @Singleton BusinessService provideBusinessService(ApiServiceFactory serviceFactory) {
    return serviceFactory.create(BusinessService.class);
  }

  @Provides @Singleton ShiftService provideShiftService(ApiServiceFactory serviceFactory) {
    return serviceFactory.create(ShiftService.class);
  }

  @Provides @Singleton LocationManager provideLocationManager(Context context) {
    return new LocationManager(context);
  }
}

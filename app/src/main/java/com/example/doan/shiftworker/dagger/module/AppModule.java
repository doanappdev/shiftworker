package com.example.doan.shiftworker.dagger.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.example.doan.data.RxUtil;
import com.example.doan.data.realm.RealmService;
import com.example.doan.data.repository.shift.ShiftRepositoryImpl;
import com.example.doan.data.retrofit.api.BusinessService;
import com.example.doan.data.repository.business.BusinessRepositoryImpl;
import com.example.doan.data.retrofit.api.ShiftService;
import com.example.doan.shiftworker.interactor.GetBusinessInteractor;
import com.example.doan.shiftworker.interactor.GetRealmInteractor;
import com.example.doan.shiftworker.interactor.GetShiftInteractor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by doanappdev@gmail.com on 25/3/17.
 */

@Module
public final class AppModule {
  private Context context;

  public AppModule(Context context) {this.context = context;}

  @Provides @Singleton SharedPreferences provideSharedPreferences() {
    return PreferenceManager.getDefaultSharedPreferences(context);
  }

  @Provides @Singleton Context provideContext() {
    return context;
  }

  @Provides @Singleton Gson provideGson() {
    return new GsonBuilder().create();
  }

  @Provides @Singleton GetBusinessInteractor provideGetBusinessInteractor(BusinessService businessService){
    return new GetBusinessInteractor(new BusinessRepositoryImpl(businessService, new RxUtil()));
  }

  @Provides @Singleton GetShiftInteractor provideGetShiftInteractor(ShiftService shiftService, RxUtil rxUtil) {
    return new GetShiftInteractor(new ShiftRepositoryImpl(shiftService, rxUtil));
  }

  @Provides @Singleton GetRealmInteractor provideRealmInteractor(RealmService realmService) {
    return new GetRealmInteractor(realmService);
  }
}

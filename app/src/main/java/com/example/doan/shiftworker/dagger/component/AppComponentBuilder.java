package com.example.doan.shiftworker.dagger.component;

import android.content.Context;
import com.example.doan.data.RxUtil;
import com.example.doan.shiftworker.dagger.module.AppModule;
import com.example.doan.data.dagger.DataModule;
import com.example.doan.shiftworker.dagger.module.InteractorModule;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by doanappdev@gmail.com on 25/3/17.
 */

public final class AppComponentBuilder {
  public static AppComponent build(Context context) {
    return DaggerAppComponent
        .builder()
        .appModule(new AppModule(context))
        .dataModule(new DataModule(new RxUtil(Schedulers.newThread(), AndroidSchedulers.mainThread())))
        .interactorModule(new InteractorModule())
        .build();
    //return null;
  }
}

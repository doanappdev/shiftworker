package com.example.doan.data;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by doanappdev@gmail.com on 26/3/17.
 */

public class RxUtil {

  Scheduler subscribeOnScheduler;
  Scheduler observeOnScheduler;

  public RxUtil() {
    this(Schedulers.io(), AndroidSchedulers.mainThread());
  }

  public RxUtil(Scheduler subscribeOnScheduler, Scheduler observeOnScheduler) {
    this.subscribeOnScheduler = subscribeOnScheduler;
    this.observeOnScheduler = observeOnScheduler;
  }

  public Scheduler getSubscribeOnScheduler() {
    return subscribeOnScheduler;
  }

  public Scheduler getObserveOnScheduler() {
    return observeOnScheduler;
  }


}

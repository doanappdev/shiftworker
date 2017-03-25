package com.example.doan.data.shift;

import rx.Observable;

/**
 * Created by doanappdev@gmail.com on 25/3/17.
 */

public class ShiftRepositoryImpl implements ShiftRepository {
  @Override public Observable<String> getShiftTimes() {
    return Observable.just("Test Data");
  }
}

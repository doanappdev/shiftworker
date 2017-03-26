package com.example.doan.data.repository.shift;

import com.example.doan.data.RxUtil;
import com.example.doan.data.entities.Shift;
import com.example.doan.data.entities.ShiftInfo;
import com.example.doan.data.retrofit.api.ShiftService;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by doanappdev@gmail.com on 26/3/17.
 */

public class ShiftRepositoryImpl implements ShiftRepository {
  private ShiftService shiftService;
  private RxUtil rxUtil;

  public ShiftRepositoryImpl(ShiftService shiftService, RxUtil rxUtil) {
    this.shiftService = shiftService;
    this.rxUtil = rxUtil;
  }

  @Override public Completable shiftStart(ShiftInfo shiftInfo) {
    return shiftService
        .shiftStart(shiftInfo)
        .subscribeOn(rxUtil.getSubscribeOnScheduler())
        .observeOn(rxUtil.getObserveOnScheduler());
  }

  @Override public Completable shiftEnd(ShiftInfo shiftInfo) {
    return shiftService
        .shiftEnd(shiftInfo)
        .subscribeOn(rxUtil.getSubscribeOnScheduler())
        .observeOn(rxUtil.getObserveOnScheduler());
  }

  @Override public Observable<List<Shift>> getShifts() {
    return shiftService
        .getShifts()
        .subscribeOn(rxUtil.getSubscribeOnScheduler())
        .observeOn(rxUtil.getObserveOnScheduler());
  }
}

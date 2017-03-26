package com.example.doan.shiftworker.ui;

import android.os.Handler;
import android.util.Log;
import com.example.doan.data.entities.Business;
import com.example.doan.data.entities.Shift;
import com.example.doan.data.entities.ShiftInfo;
import com.example.doan.shiftworker.base.BasePresenter;
import com.example.doan.shiftworker.base.BaseView;
import com.example.doan.shiftworker.interactor.GetBusinessInteractor;

import com.example.doan.shiftworker.interactor.GetShiftInteractor;
import io.reactivex.Completable;
import io.reactivex.observers.DisposableCompletableObserver;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by doanappdev@gmail.com on 26/3/17.
 */

public class MainPresenter extends BasePresenter<MainPresenter.View> {
  private static final String TAG = MainPresenter.class.getSimpleName();
  interface View extends BaseView {
    void printBusinessInfo(Business business);
    void displayShiftList(List<Shift> shifts);
  }

  private GetBusinessInteractor businessInteractor;
  private GetShiftInteractor shiftInteractor;

  @Inject public MainPresenter(GetBusinessInteractor businessInteractor, GetShiftInteractor shiftInteractor) {
    this.businessInteractor = businessInteractor;
    this.shiftInteractor = shiftInteractor;
  }

  public void initData() {
    businessInteractor
        .getBusiness()
        .subscribe(this::printBusinessInfo);
  }

  public void onStartShift() {
    shiftInteractor
        .shiftStart(new ShiftInfo())
        .subscribe();
  }

  public void onEndShift() {
    shiftInteractor
        .shiftEnd(new ShiftInfo())
        .subscribe();
  }

  public void onDisplayShifts() {
    shiftInteractor
        .getShifts()
        .subscribe(shifts -> printShiftDetails(shifts));
  }

  private void printShiftDetails(List<Shift> shifts) {
    view.displayShiftList(shifts);
    //for(Shift s : shift) {
    //  Log.d(TAG, "id : " + s.getId());
    //  Log.d(TAG, "start : " + s.getStart());
    //  Log.d(TAG, "end : " + s.getEnd());
    //  Log.d(TAG, "startLatitude : " + s.getStartLatitude());
    //  Log.d(TAG, "startLongitude : " + s.getStartLongitude());
    //  Log.d(TAG, "endLatitude : " + s.getEndLatitude());
    //  Log.d(TAG, "endLongitude : " + s.getEndLongitude());
    //  Log.d(TAG, "startLatitude : " + s.getStartLatitude());
    //  Log.d(TAG, "image : " + s.getImage());
    //}
  }

  private void printBusinessInfo(Business business) {
    view.printBusinessInfo(business);
  }
}

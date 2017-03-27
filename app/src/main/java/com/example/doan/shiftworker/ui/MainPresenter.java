package com.example.doan.shiftworker.ui;

import com.example.doan.data.entities.Business;
import com.example.doan.data.entities.Shift;
import com.example.doan.data.entities.ShiftInfo;
import com.example.doan.data.location.LocationManager;
import com.example.doan.data.realm.RealmServiceImpl;
import com.example.doan.shiftworker.base.BasePresenter;
import com.example.doan.shiftworker.base.BaseView;
import com.example.doan.shiftworker.interactor.GetBusinessInteractor;

import com.example.doan.shiftworker.interactor.GetRealmInteractor;
import com.example.doan.shiftworker.interactor.GetShiftInteractor;
import java.util.List;
import javax.inject.Inject;
import org.reactivestreams.Subscription;

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
  private LocationManager locationManager;
  private GetRealmInteractor realmInteractor;

  @Inject public MainPresenter(GetBusinessInteractor businessInteractor,
      GetShiftInteractor shiftInteractor, GetRealmInteractor realmInteractor,
      LocationManager locationManager) {
    this.businessInteractor = businessInteractor;
    this.shiftInteractor = shiftInteractor;
    this.locationManager = locationManager;
    this.realmInteractor = realmInteractor;
  }

  public void initData() {
    businessInteractor
        .getBusiness()
        .subscribe(this::printBusinessInfo);
  }

  public void onStartShift() {
    shiftInteractor
        .shiftStart(new ShiftInfo(locationManager.getLatitude(), locationManager.getLongitude()))
        .subscribe();
  }

  public void onEndShift() {
    shiftInteractor
        .shiftEnd(new ShiftInfo(locationManager.getLatitude(), locationManager.getLongitude()))
        .subscribe();
  }

  public void onDisplayShifts() {
    shiftInteractor
        .getShifts()
        .map(shifts -> {
          for (Shift s : shifts) {
            realmInteractor.newShift(s);
          }
          return shifts;
        })
        .subscribe(shifts -> displayShiftList(shifts));
  }

  public void onDisplayShiftsRealm() {
    realmInteractor.shifts().subscribe(shifts -> displayShiftList(shifts));
  }

  private void displayShiftList(List<Shift> shifts) {
    view.displayShiftList(shifts);
  }

  private void printBusinessInfo(Business business) {
    view.printBusinessInfo(business);
  }
}

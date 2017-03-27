package com.example.doan.shiftworker.interactor;

import com.example.doan.data.entities.Shift;
import com.example.doan.data.realm.RealmService;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by doanappdev@gmail.com on 27/3/17.
 */

public class GetRealmInteractor {
  RealmService realmService;

  public GetRealmInteractor(RealmService realmService) {
    this.realmService = realmService;
  }

  public Observable<List<Shift>> shifts() {
    return realmService.shifts();
  }

  public void newShift(Shift shift) {
    realmService.saveShift(shift);
  }
}

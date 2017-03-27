package com.example.doan.data.realm;

import android.util.Log;
import com.example.doan.data.entities.Shift;
import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmResults;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by doanappdev@gmail.com on 27/3/17.
 */

public class RealmServiceImpl implements RealmService {
  private static final String TAG = RealmServiceImpl.class.getSimpleName();
  Realm realm;
  public RealmServiceImpl(Realm realm) {
    this.realm = realm;
  }

  @Override public Observable<List<Shift>> shifts() {
    List<Shift> shiftList = new ArrayList<>();
    RealmResults<Shift> results = realm.where(Shift.class).findAll();
    for(Shift s : results) {
      shiftList.add(s);
    }
    return Observable.just(shiftList);
  }

  @Override public void saveShift(Shift shift) {
    realm.beginTransaction();
    realm.copyToRealm(shift);
    Log.d(TAG, "Shift saved --->");
    Log.d(TAG, "Shift id : " + shift.getId());
    realm.commitTransaction();
  }
}

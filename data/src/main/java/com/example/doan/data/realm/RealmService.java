package com.example.doan.data.realm;

import com.example.doan.data.entities.Shift;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by doanappdev@gmail.com on 27/3/17.
 */

public interface RealmService {
  Observable<List<Shift>> shifts();
  void saveShift(Shift shift);
}

package com.example.doan.data.repository.shift;

import com.example.doan.data.entities.Shift;
import com.example.doan.data.entities.ShiftInfo;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by doanappdev@gmail.com on 26/3/17.
 */

public interface ShiftRepository {
  Completable shiftStart(final ShiftInfo shiftInfo);
  Completable shiftEnd(final ShiftInfo shiftInfo);
  Observable<List<Shift>> getShifts();
}

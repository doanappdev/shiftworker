package com.example.doan.shiftworker.interactor;

import com.example.doan.data.entities.Shift;
import com.example.doan.data.entities.ShiftInfo;
import com.example.doan.data.repository.shift.ShiftRepository;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by doanappdev@gmail.com on 26/3/17.
 */

public class GetShiftInteractor {
  ShiftRepository shiftRepository;

  public GetShiftInteractor(ShiftRepository shiftRepository) {
    this.shiftRepository = shiftRepository;
  }

  public Completable shiftStart(ShiftInfo shiftInfo) {
    return shiftRepository.shiftStart(shiftInfo);
  }

  public Completable shiftEnd(ShiftInfo shiftInfo) {
    return shiftRepository.shiftEnd(shiftInfo);
  }

  public Observable<List<Shift>> getShifts() {
    return shiftRepository.getShifts();
  }
}

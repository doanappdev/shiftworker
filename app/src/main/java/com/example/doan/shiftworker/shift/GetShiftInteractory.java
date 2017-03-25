package com.example.doan.shiftworker.shift;

import com.example.doan.data.shift.ShiftRepository;
import rx.Observable;

/**
 * Created by doanappdev@gmail.com on 26/3/17.
 */

public class GetShiftInteractory {
  ShiftRepository shiftRepository;

  public GetShiftInteractory(ShiftRepository shiftRepository) {
    this.shiftRepository = shiftRepository;
  }

  public Observable<String> getShiftTime() {
    return shiftRepository.getShiftTimes();
  }
}

package com.example.doan.data.shift;

import rx.Observable;

/**
 * Created by doanappdev@gmail.com on 26/3/17.
 */

public interface ShiftRepository {

  //Observable<BillId> getBillId(String accountId, String billId);

  //Observable<BillDetails> getBillDetails(String accountId, String billId);

  Observable<String> getShiftTimes();
}

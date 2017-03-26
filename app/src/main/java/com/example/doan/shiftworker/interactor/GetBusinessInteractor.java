package com.example.doan.shiftworker.interactor;

import com.example.doan.data.entities.Business;
import com.example.doan.data.repository.business.BusinessRepository;
import io.reactivex.Observable;

/**
 * Created by doanappdev@gmail.com on 26/3/17.
 */

public class GetBusinessInteractor {
  BusinessRepository businessRepository;

  public GetBusinessInteractor(BusinessRepository businessRepository) {
    this.businessRepository = businessRepository;
  }

  public Observable<Business> getBusiness() {
    return businessRepository.getBusiness();
  }

  //public Observable<String> getShiftTime() {
  //  return businessRepository.getShiftTimes();
  //}
  //
  //public String getShiftString() {return businessRepository.getShiftString();}
}

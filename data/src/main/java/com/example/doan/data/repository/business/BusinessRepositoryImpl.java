package com.example.doan.data.repository.business;

import com.example.doan.data.RxUtil;
import com.example.doan.data.entities.Business;
import com.example.doan.data.repository.business.BusinessRepository;
import com.example.doan.data.retrofit.api.BusinessService;
import io.reactivex.Observable;

/**
 * Created by doanappdev@gmail.com on 25/3/17.
 */

public class BusinessRepositoryImpl implements BusinessRepository {

  private BusinessService businessService;
  private RxUtil rxUtil;

  public BusinessRepositoryImpl(BusinessService businessService, RxUtil rxUtil) {
    this.businessService = businessService;
    this.rxUtil = rxUtil;
  }

  @Override public Observable<Business> getBusiness() {
    return businessService
        .getBusiness()
        .subscribeOn(rxUtil.getSubscribeOnScheduler())
        .observeOn(rxUtil.getObserveOnScheduler());
  }
}

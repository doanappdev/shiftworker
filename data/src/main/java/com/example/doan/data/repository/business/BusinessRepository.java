package com.example.doan.data.repository.business;

import com.example.doan.data.entities.Business;
import io.reactivex.Observable;

/**
 * Created by doanappdev@gmail.com on 26/3/17.
 */

public interface BusinessRepository {
  Observable<Business> getBusiness();
}

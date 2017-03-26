package com.example.doan.data.retrofit.api;

import com.example.doan.data.entities.Business;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;


import static com.example.doan.data.retrofit.ApiServiceFactory.AUTH_SHA1;

/**
 * Created by doanappdev@gmail.com on 25/3/17.
 */

public interface BusinessService {
  @Headers("Authorization:Deputy " + AUTH_SHA1)
  @GET("business")
  Observable<Business> getBusiness();
}

package com.example.doan.data.retrofit.api;

import com.example.doan.data.entities.Shift;
import com.example.doan.data.entities.ShiftInfo;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import static com.example.doan.data.retrofit.ApiServiceFactory.AUTH_SHA1;

/**
 * Created by doanappdev@gmail.com on 26/3/17.
 */

public interface ShiftService {
  @Headers("Authorization:Deputy " + AUTH_SHA1)
  @POST("shift/start")
  Completable shiftStart(@Body ShiftInfo shiftInfo);

  @Headers("Authorization:Deputy " + AUTH_SHA1)
  @POST("shift/end")
  Completable shiftEnd(@Body ShiftInfo shiftInfo);

  @Headers("Authorization:Deputy " + AUTH_SHA1)
  @GET("shifts")
  Observable<List<Shift>> getShifts();
}

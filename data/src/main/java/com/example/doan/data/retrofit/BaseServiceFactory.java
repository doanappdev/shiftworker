package com.example.doan.data.retrofit;

import com.example.doan.data.BuildConfig;
import com.google.gson.Gson;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by doanappdev@gmail.com on 25/3/17.
 */

public abstract class BaseServiceFactory {

  //protected EnvironmentRepository environmentRepository;
  protected Gson gson;
  //protected CookieJarImpl cookieJarImpl;

  public BaseServiceFactory(Gson gson) {
    //this.environmentRepository = environmentRepository;
    this.gson = gson;
    //this.cookieJarImpl = cookieJarImpl;
  }

  public abstract <T> T create(Class<T> serviceType);

  protected <T> T buildNetworkAdapter(HttpUrl baseUrl, Class<T> serviceType) {
    OkHttpClient httpClient = getHttpClient();

    Retrofit retrofit = new Retrofit.Builder()
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .baseUrl(baseUrl)
        .build();

    return retrofit.create(serviceType);
  }

  protected OkHttpClient getHttpClient() {
    OkHttpClient.Builder builder = new OkHttpClient.Builder()
        .addInterceptor(e -> e.proceed(e.request()));

    if(!BuildConfig.BUILD_TYPE.equals("release")) {
      builder.addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
    }
    return builder.build();
  }
}

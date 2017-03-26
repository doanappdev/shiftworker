package com.example.doan.data.retrofit;

import com.google.gson.Gson;
import okhttp3.HttpUrl;

/**
 * Created by doanappdev@gmail.com on 25/3/17.
 */

public class ApiServiceFactory extends BaseServiceFactory {
  public static final HttpUrl BASE_URL = HttpUrl.parse("https://apjoqdqpi3.execute-api.us-west-2.amazonaws.com/dmc/");
  public static final String AUTH_SHA1 = "aa93e733a85dcd3e134fca45d926427e19a05afb1";

  public ApiServiceFactory(Gson gson) {
    super(gson);
  }

  @Override public <T> T create(Class<T> serviceType) {
    //String baseUrl = environmentRepository.getEnvironment().baseServiceUrl;
    return buildNetworkAdapter(BASE_URL, serviceType);
  }
}

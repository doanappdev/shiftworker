package com.example.doan.data.dagger;

import android.net.ConnectivityManager;
import com.google.gson.Gson;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import javax.inject.Singleton;

/**
 * Created by doanappdev@gmail.com on 25/3/17.
 */

@Module
public class DataModule {
  private File cacheDir;
  //private RxUtil rxUtil;

  public DataModule(File cacheDir, RxUtil rxUtil) {
    this.cacheDir = cacheDir;
    this.rxUtil = rxUtil;
  }

  //@Provides
  //@Singleton
  //public Shelf provideShelf() {
  //  return new Shelf(cacheDir);
  //}
  //
  //@Provides
  //@Singleton
  //RxUtil provideRxUtil() {
  //  return rxUtil;
  //}
  //
  //@Provides
  //public List<Environment> provideEnvironments() {



  //  // NOTE: The base service URL has to end with with "/" and the URI's for the individual methods should not start with
  //  // "/". Having the URI's start with "/" causes Retrofit2 to resolve the complete URL incorrectly.
  //  // See this stackoverflow article for more detail:
  //  // http://stackoverflow.com/questions/32352159/retrofit-2-removes-characters-after-hostname-from-base-url
  //  return Arrays.asList(
  //      Environment.create(
  //          "dev", "Dev",
  //          "https://deviceesb-dev.sprint.com/api/digital/",
  //          "https://dev5-www.dev.sprint.com/",
  //          "https://zone-test.sprint.com/",
  //          "http://deviceesb-dev.wabaw.net/auth/oauth/v2/"),
  //
  //      Environment.create(
  //          "systest", "Systest",
  //          "https://deviceesb.systest.sprint.com/api/digital/",
  //          "https://st1-www.test.sprint.com",
  //          "https://zone-test.sprint.com/",
  //          "http://deviceesb.systest.wabaw.net/auth/oauth/v2/"),
  //
  //      Environment.create(
  //          "rtb1", "RTB1",
  //          "https://deviceesb.rtb1.sprint.com/api/digital/",
  //          "https://rtb1-www.test.sprint.com",
  //          "https://zone-test.sprint.com/",
  //          "http://deviceesb.rtb1.wabaw.net/auth/oauth/v2/")
  //  );
  //}
  //
  //// ENVIRONMENT
  //// repository
  //@Provides
  //@Singleton
  //public EnvironmentRepository provideEnvironmentRepository(Shelf shelf, List<Environment> environments) {
  //  return new EnvironmentRepository(shelf, environments);
  //}
  //
  //// Cookie Jar
  //@Provides
  //@Singleton
  //public CookieJarImpl provideCookieJarImpl() {
  //  return new CookieJarImpl();
  //}
  //
  //// Service Factories
  //@Provides
  //protected ApiServiceFactory provideApiServiceFactory(EnvironmentRepository environmentRepository, Gson gson, CookieJarImpl cookieJar) {
  //  return new ApiServiceFactory(environmentRepository, gson, cookieJar);
  //}
  //@Provides
  //protected BmwServiceFactory provideBmwServiceFactory(EnvironmentRepository environmentRepository, Gson gson, CookieJarImpl cookieJar) {
  //  return new BmwServiceFactory(environmentRepository, gson, cookieJar);
  //}
  //@Provides
  //protected AuthenticationServiceFactory provideAuthServiceFactory(EnvironmentRepository environmentRepository, Gson gson, CookieJarImpl cookieJar) {
  //  return new AuthenticationServiceFactory(environmentRepository, gson, cookieJar);
  //}
  //
  //// BILLING
  //// service
  //@Provides
  //@Singleton
  //public BillingService provideBillService(ApiServiceFactory serviceFactory) {
  //  return serviceFactory.create(BillingService.class);
  //}
  //// repository
  //@Provides
  //@Singleton
  //public BillingRepository provideBillRepository(BillingService billingService, RxUtil rxUtil) {
  //  return new BillingRepositoryImpl(billingService, rxUtil);
  //}
  //
  //// USAGE
  //// service
  //@Provides
  //@Singleton
  //public UsageService provideUsageService(ApiServiceFactory serviceFactory) {
  //  return serviceFactory.create(UsageService.class);
  //}
  //// repository
  //@Provides
  //@Reusable
  //public UsageRepository provideUsageRepository(UsageService service, Shelf shelf, RxUtil rxUtil) {
  //  return new UsageRepositoryImpl(service, shelf, rxUtil);
  //}
  //
  //// ACCOUNT - postpaid
  //// service
  //@Provides
  //@Singleton
  //public AccountService provideAccountService(ApiServiceFactory serviceFactory) {
  //  return serviceFactory.create(AccountService.class);
  //}
  //// repository
  //@Provides
  //@Singleton
  //public AccountRepository provideAccountRepository(AccountService service, BillingRepository billingRepository,
  //    OauthRepository oauthRepository, RxUtil rxUtil, Shelf shelf) {
  //  return new AccountRepositoryImpl(service, billingRepository, oauthRepository, rxUtil, shelf);
  //}
  //
  //// ACCOUNT - prepaid
  //// service
  //@Provides
  //@Singleton
  //public PrepaidAccountService providePrepaidAccountService(ApiServiceFactory serviceFactory) {
  //  return serviceFactory.create(PrepaidAccountService.class);
  //}
  //// repository
  //@Provides
  //@Reusable
  //public PrepaidAccountRepository providePrepaidAccountRepository(PrepaidAccountService service, RxUtil rxUtil, Shelf shelf) {
  //  return new PrepaidAccountRepositoryImpl(service, rxUtil);
  //}
  //
  //// PAYMENT
  //// service
  //@Provides
  //@Singleton
  //public PaymentService providePaymentService(ApiServiceFactory serviceFactory) {
  //  return serviceFactory.create(PaymentService.class);
  //}
  //// repository
  //@Provides
  //@Reusable
  //public PaymentRepository providePaymentRepository(PaymentService paymentService, RxUtil rxUtil) {
  //  return new PaymentRepositoryImpl(paymentService, rxUtil);
  //}
  //
  //// SUPPORT
  //// service
  //@Provides
  //@Reusable
  //public SupportService provideSupportService(ApiServiceFactory serviceFactory){
  //  return serviceFactory.create(SupportService.class);
  //}
  //// repository
  //@Provides
  //@Reusable
  //public SupportRepository provideSupportRepository(SupportService supportService, RxUtil rxUtil, Shelf shelf) {
  //  return new SupportRepositoryImpl(supportService, rxUtil, shelf);
  //}
  //
  //// PLAN
  //// service
  //@Provides
  //@Singleton
  //public PlanService providePlanService(ApiServiceFactory serviceFactory) {
  //  return serviceFactory.create(PlanService.class);
  //}
  //// repository
  //@Provides
  //@Reusable
  //public PlanRepository providePlanRepository(PlanService planService, RxUtil rxUtil) {
  //  return new PlanRepositoryImpl(planService, rxUtil);
  //}
  //
  //// AEM
  //// service
  //@Provides
  //@Singleton
  //public AEMService provideAEMService(ApiServiceFactory serviceFactory){ //TODO: will AEM need a different endpoint / service factory?
  //  return serviceFactory.create(AEMService.class);
  //}
  //// repository
  //@Provides
  //@Reusable
  //public AEMRepository provideAEMRepository(AEMService service, RxUtil rxUtil, Shelf shelf){
  //  return new AEMRepositoryImpl(service, rxUtil, shelf);
  //}
  //
  //// BMW Analytics
  //// service
  //@Provides
  //@Singleton
  //public BmwService provideBmwService(BmwServiceFactory serviceFactory) {
  //  return serviceFactory.create(BmwService.class);
  //}
  //// repository
  //@Provides
  //@Reusable
  //public BmwRepository provideBmwRepositoryImpl(Shelf shelf, BmwService bmwService, RxUtil rxUtil) {
  //  return new BmwRepositoryImpl(shelf, bmwService, rxUtil);
  //}
  //
  //// MAG
  //// service
  //@Provides
  //@Singleton
  //public MagNetworkService provideMagNetworkService(ConnectivityManager connectivityManager) {
  //  return new MagNetworkService(connectivityManager);
  //}
  //
  //// oAuth
  //// credentials
  //@Provides
  //@Singleton
  //public OauthCredentials provideOauthCredentials() {
  //  return new OauthCredentials();
  //}
  //// service
  //@Provides
  //@Singleton
  //public OauthService provideOauthService(AuthenticationServiceFactory serviceFactory){
  //  return serviceFactory.create(OauthService.class);
  //}
  //// repository
  //@Provides
  //@Singleton
  //public OauthRepository provideOauthRepository(CookieJarImpl cookieJar, OauthService oauthService, OauthCredentials oauthCredentials, MagNetworkService magNetworkService, RxUtil rxUtil, Shelf shelf, Gson gson){
  //  return new OauthRepositoryImpl(cookieJar, oauthService, oauthCredentials, magNetworkService, rxUtil, shelf, gson);
  //}
  //
  //// user
  ////service
  //@Provides
  //@Singleton
  //public UserService provideUserService(ApiServiceFactory serviceFactory) {
  //  return serviceFactory.create(UserService.class);
  //}
  ////repository
  //@Provides
  //@Reusable
  //public UserRepository provideUserRepository(UserService service, RxUtil rxUtil, Shelf shelf) {
  //  return new UserRepositoryImpl(service, rxUtil, shelf);
  //}

}

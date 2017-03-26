package com.example.doan.shiftworker.base;

import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscription;

/**
 * Created by doanappdev@gmail.com on 26/3/17.
 */

public abstract class BasePresenter<V extends BaseView> {
  protected V view;
  //protected Disposable disposable;
  //protected CompositeSubscription subscriptions = new CompositeSubscription();

  public void attachView(V view) {
    this.view = view;
  }

  /**
   * Check if view is attached to presenter.
   *
   * @return true | false depends if view is null or not
   */
  public boolean isViewAttached(){
    return this.view != null;
  }

  public void detachView() {
    this.view = null;
    //this.subscriptions.unsubscribe();
  }

  public void addSubscription(Subscription subscription) {
    //subscriptions.add(subscription);
  }
}

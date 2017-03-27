package com.example.doan.shiftworker.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscription;

/**
 * Created by doanappdev@gmail.com on 26/3/17.
 */

public abstract class BasePresenter<V extends BaseView> {
  protected V view;
  protected CompositeDisposable composites = new CompositeDisposable();

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
    composites.dispose();
  }

  public void addDisposable(Disposable disposable) {
    composites.add(disposable);
  }
}

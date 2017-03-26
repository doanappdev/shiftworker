package com.example.doan.shiftworker.dagger.component;

import com.example.doan.shiftworker.MainActivity;
import com.example.doan.shiftworker.dagger.PerActivity;
import com.example.doan.shiftworker.dagger.component.AppComponent;
import dagger.Component;

/**
 * Created by doanappdev@gmail.com on 25/3/17.
 */

@PerActivity
@Component(dependencies = AppComponent.class)
public interface UiComponent {

  /* Activities */
  void inject(MainActivity activity);
  //void inject(ViewPagerActivity activity);
  //void inject(SignatureActivity activity);

  /* Layouts */
  //void inject(InvoiceSummaryLayout layout);
  //void inject(InvoiceLayout layout);

}

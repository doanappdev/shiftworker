package com.example.doan.shiftworker.dagger.component;

import com.example.doan.shiftworker.ui.MainActivity;
import com.example.doan.shiftworker.dagger.PerActivity;
import com.example.doan.shiftworker.ui.ShiftDetailActivity;
import dagger.Component;

/**
 * Created by doanappdev@gmail.com on 25/3/17.
 */

@PerActivity
@Component(dependencies = AppComponent.class)
public interface UiComponent {
  void inject(MainActivity activity);
  void inject(ShiftDetailActivity activity);
}

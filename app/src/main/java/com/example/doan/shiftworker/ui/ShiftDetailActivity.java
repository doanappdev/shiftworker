package com.example.doan.shiftworker.ui;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.example.doan.data.entities.Shift;
import com.example.doan.shiftworker.R;
import com.example.doan.shiftworker.base.BaseActivity;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.parceler.Parcels;

public class ShiftDetailActivity extends BaseActivity {

  @BindView(R.id.icon_iv) ImageView iconImgView;
  @BindView(R.id.id_tv) TextView idTxtView;
  @BindView(R.id.start_tv) TextView startTxtView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_shift_detail);
    ButterKnife.bind(this);
  }

  @Override protected void onPostCreate(@Nullable Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    Shift shift = Parcels.unwrap(getIntent().getParcelableExtra(getString(R.string.key_shift)));

    if (shift != null) {
      Glide.with(this).load(shift.getImage()).into(iconImgView);
      idTxtView.setText(String.valueOf(shift.getId()));

      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
      String formattedDate = formatter.format(shift.getStart());
      startTxtView.setText(formattedDate);
    }
  }
}

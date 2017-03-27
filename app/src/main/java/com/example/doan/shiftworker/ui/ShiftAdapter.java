package com.example.doan.shiftworker.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.bumptech.glide.Glide;
import com.example.doan.data.entities.Shift;
import com.example.doan.shiftworker.R;
import java.util.List;

/**
 * Created by doanappdev@gmail.com on 26/3/17.
 */

public class ShiftAdapter extends RecyclerView.Adapter<ShiftAdapter.ShiftViewHolder> {

  private Context context;
  private List<Shift> shiftList;
  private OnShiftItemClick listener;

  interface OnShiftItemClick {
    void onShiftItemClick(Shift shift);
  }

  public ShiftAdapter(Context context, List<Shift> shiftList, OnShiftItemClick listener) {
    this.shiftList = shiftList;
    this.context = context;
    this.listener = listener;
  }

  @Override public ShiftViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ShiftViewHolder(LayoutInflater
        .from(context)
        .inflate(R.layout.item_shift, parent, false));
  }

  @Override public void onBindViewHolder(ShiftViewHolder holder, int position) {
    Shift shift = shiftList.get(position);
    holder.bindData(context, shift, listener);
  }

  @Override public int getItemCount() {
    return shiftList.size();
  }

  public static class ShiftViewHolder extends RecyclerView.ViewHolder {
      @BindView(R.id.icon_iv) ImageView iconIv;
      @BindView(R.id.id_tv) TextView idTv;
      @BindView(R.id.start_date_time_tv) TextView startTv;

    private OnShiftItemClick listener;
    private Shift shift;
    public ShiftViewHolder(View view) {
      super(view);
      ButterKnife.bind(this, view);
    }

    public void bindData(Context context, Shift shift, OnShiftItemClick listener) {
      Glide.with(context).load(shift.getImage()).into(iconIv);
      idTv.setText(String.valueOf(shift.getId()));
      startTv.setText(shift.getStartDate().toString());
      this.listener = listener;
      this.shift = shift;
    }

    @OnClick(R.id.item_container) void onItemClick() {
      listener.onShiftItemClick(shift);
    }
  }
}

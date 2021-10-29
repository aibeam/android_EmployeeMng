package com.example.sampleemployeemng;

import android.view.View;

public interface OnEmployeeItemClickListener {
    public void onItemClick(EmployeeAdapter.ViewHolder holder, View v, int position);
}

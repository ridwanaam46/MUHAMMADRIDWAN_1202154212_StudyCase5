package com.example.asusx453sa.muhammadridwan_1202154212_studycase5;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by ASUS X453SA on 3/24/2018.
 */

class SwipeUtilDelete extends ItemTouchHelper.Callback {
    public SwipeUtilDelete(int i, int left, MainActivity mainActivity) {
    }

    public void setLeftcolorCode(int color) {
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return 0;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }
}

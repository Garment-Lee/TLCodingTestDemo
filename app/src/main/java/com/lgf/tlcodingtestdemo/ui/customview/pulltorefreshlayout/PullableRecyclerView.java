package com.lgf.tlcodingtestdemo.ui.customview.pulltorefreshlayout;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ligf on 2018/5/22.
 */

public class PullableRecyclerView extends RecyclerView implements Pullable{

    public PullableRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean canPullDown() {
        boolean allowToPull = false;
        View firstChild = getChildAt(0);
        if (firstChild != null) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int firstVisiblePosition = linearLayoutManager.findFirstVisibleItemPosition();
            if (firstVisiblePosition == 0 && firstChild.getTop() == 0) {
                allowToPull = true;
            } else {
                allowToPull = false;
            }
        } else {
            allowToPull = true;
        }
        return allowToPull;
    }

    @Override
    public boolean canPullUp() {
        return false;
    }
}

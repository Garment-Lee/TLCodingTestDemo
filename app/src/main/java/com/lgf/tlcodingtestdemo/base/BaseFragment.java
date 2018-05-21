package com.lgf.tlcodingtestdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by garment on 2018/5/21.
 */

public abstract class BaseFragment extends android.support.v4.app.Fragment {

    private View layout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        layout = inflater.inflate(getLayoutId(), container, false);
        initViews();
        initData();
        return layout;
    }

    protected View findViewById(int id){
        return layout.findViewById(id);
    }

    public abstract int getLayoutId();
    public abstract void initViews();
    public abstract void initData();
}

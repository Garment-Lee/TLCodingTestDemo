package com.lgf.tlcodingtestdemo.ui.fragment;

import com.lgf.tlcodingtestdemo.R;
import com.lgf.tlcodingtestdemo.base.BaseFragment;

/**
 * Created by garment on 2018/5/21.
 */

public class ShopFragment extends BaseFragment {

    public static ShopFragment getInstance(){
        ShopFragment shopFragment = new ShopFragment();
        return shopFragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_shop;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initData() {

    }
}

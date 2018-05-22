package com.lgf.tlcodingtestdemo.ui.fragment;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lgf.tlcodingtestdemo.R;
import com.lgf.tlcodingtestdemo.base.BaseFragment;
import com.lgf.tlcodingtestdemo.bean.ShowingContentBean;
import com.lgf.tlcodingtestdemo.ui.adapter.ContentShowingRVAdapter;
import com.lgf.tlcodingtestdemo.ui.customview.IInterceptChecker;
import com.lgf.tlcodingtestdemo.ui.customview.LoadingRefreshLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by garment on 2018/5/21.
 */

public class ShopFragment extends BaseFragment implements LoadingRefreshLayout.OnRefreshListener, IInterceptChecker{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mRecyclerViewAdapter;
    /**缓存需要展示的数据列表*/
    private List<ShowingContentBean> mContentBeanList = new ArrayList<>();
    /**自定义的下拉加载布局*/
//    private PullToRefreshLayout mLoadingRefreshLayout;
    private LoadingRefreshLayout mLoadingRefreshLayout;

    private Handler handler = new Handler();


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
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_shop);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerViewAdapter = new ContentShowingRVAdapter(mContentBeanList);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        mLoadingRefreshLayout = (LoadingRefreshLayout) findViewById(R.id.loading_refresh_layout_shop);
        mLoadingRefreshLayout.setInterceptChecker(this);
        mLoadingRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public boolean isAllowToIntercept() {
        boolean allowToPull = false;
        View firstChild = mRecyclerView.getChildAt(0);
        if (firstChild != null) {
            RecyclerView.LayoutManager layoutManager = mRecyclerView.getLayoutManager();
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
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mLoadingRefreshLayout.finishLoading();
            }
        }, 2000);
    }
}

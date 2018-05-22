package com.lgf.tlcodingtestdemo.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lgf.tlcodingtestdemo.R;
import com.lgf.tlcodingtestdemo.base.BaseFragment;
import com.lgf.tlcodingtestdemo.bean.ShowingContentBean;
import com.lgf.tlcodingtestdemo.ui.adapter.ContentShowingRVAdapter;
import com.lgf.tlcodingtestdemo.ui.customview.pulltorefreshlayout.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by garment on 2018/5/21.
 */

public class EatFragment extends BaseFragment implements PullToRefreshLayout.OnRefreshListener{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mRecyclerViewAdapter;
    /**缓存需要展示的数据列表*/
    private List<ShowingContentBean> mContentBeanList = new ArrayList<>();
    /**自定义的下拉加载布局*/
    private PullToRefreshLayout mLoadingRefreshLayout;

    public static EatFragment getInstance(){
        EatFragment eatFragment = new EatFragment();
        return eatFragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_city_guide;
    }

    @Override
    public void initViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_city_guide);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerViewAdapter = new ContentShowingRVAdapter(mContentBeanList);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        mLoadingRefreshLayout = (PullToRefreshLayout) findViewById(R.id.loading_refresh_layout_city_guide);
        mLoadingRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {

    }

    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {

    }
}

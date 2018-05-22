package com.lgf.tlcodingtestdemo.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lgf.tlcodingtestdemo.R;
import com.lgf.tlcodingtestdemo.base.BaseFragment;
import com.lgf.tlcodingtestdemo.bean.ShowingContentBean;
import com.lgf.tlcodingtestdemo.bll.LoadingContentBll;
import com.lgf.tlcodingtestdemo.ui.adapter.ContentShowingRVAdapter;
import com.lgf.tlcodingtestdemo.ui.customview.pulltorefreshlayout.PullToRefreshLayout;
import com.lgf.tlcodingtestdemo.utils.LogUtil;
import com.lgf.tlcodingtestdemo.utils.UrlConfig;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by garment on 2018/5/21.
 * @description: city guide的Fragment页面
 */

public class CityGuideFragment extends BaseFragment implements PullToRefreshLayout.OnRefreshListener{

    public static final String TAG = "CityGuideFragment";

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mRecyclerViewAdapter;
    /**缓存需要展示的数据列表*/
    private List<ShowingContentBean> mContentBeanList = new ArrayList<>();
    /**自定义的下拉加载布局*/
    private PullToRefreshLayout mLoadingRefreshLayout;

    public static CityGuideFragment getInstance(){
        CityGuideFragment fragment = new CityGuideFragment();
        return fragment;
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
        //首次进入页面加载新数据
        LoadingContentBll.getInstance().getShowingCityGuideData(UrlConfig.LOADING_CITY_GUIDE_CONTENT_URL, new Observer<ArrayList<ShowingContentBean>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ArrayList<ShowingContentBean> value) {
                if (value != null && value.size() > 0){
                    mContentBeanList.addAll(value);
                    mRecyclerViewAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onError(Throwable e) {
                LogUtil.i(TAG, "initData onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }


    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        LoadingContentBll.getInstance().getShowingCityGuideData(UrlConfig.LOADING_CITY_GUIDE_CONTENT_URL, new Observer<ArrayList<ShowingContentBean>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ArrayList<ShowingContentBean> value) {
                if (value != null && value.size() > 0){
                    mContentBeanList.addAll(value);
                    mRecyclerViewAdapter.notifyDataSetChanged();
                }
                mLoadingRefreshLayout.refreshFinish(0);

            }

            @Override
            public void onError(Throwable e) {
                LogUtil.i(TAG, "onRefresh onError: " + e.getMessage());

                mLoadingRefreshLayout.refreshFinish(0);

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {

    }
}

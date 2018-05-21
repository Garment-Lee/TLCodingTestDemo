package com.lgf.tlcodingtestdemo.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lgf.tlcodingtestdemo.R;
import com.lgf.tlcodingtestdemo.base.BaseFragment;
import com.lgf.tlcodingtestdemo.bean.ShowingContentBean;
import com.lgf.tlcodingtestdemo.bll.LoadingContentBll;
import com.lgf.tlcodingtestdemo.ui.adapter.ContentShowingRVAdapter;
import com.lgf.tlcodingtestdemo.ui.customview.IInterceptChecker;
import com.lgf.tlcodingtestdemo.ui.customview.LoadingRefreshLayout;
import com.lgf.tlcodingtestdemo.utils.UrlConfig;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by garment on 2018/5/21.
 * @description: city guide的Fragment页面
 */

public class CityGuideFragment extends BaseFragment implements LoadingRefreshLayout.OnRefreshListener,IInterceptChecker{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mRecyclerViewAdapter;
    /**缓存需要展示的数据列表*/
    private List<ShowingContentBean> mContentBeanList = new ArrayList<>();
    /**自定义的下拉加载布局*/
    private LoadingRefreshLayout mLoadingRefreshLayout;

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
        mLoadingRefreshLayout = (LoadingRefreshLayout) findViewById(R.id.loading_refresh_layout_city_guide);
        /**设置拦截事件器*/
        mLoadingRefreshLayout.setInterceptChecker(this);
        /**设置下拉加载更多回调监听器*/
        mLoadingRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void initData() {
        //首次进入页面加载新数据
        LoadingContentBll.getInstance().getShowingCityGuideContent(UrlConfig.LOADING_CITY_GUIDE_CONTENT_URL, new Observer<ArrayList<ShowingContentBean>>() {
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

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void onRefresh() {
        //下滑加载更多
        LoadingContentBll.getInstance().getShowingCityGuideContent(UrlConfig.LOADING_CITY_GUIDE_CONTENT_URL, new Observer<ArrayList<ShowingContentBean>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ArrayList<ShowingContentBean> value) {
                //加载完成，关闭加载提示
                mLoadingRefreshLayout.finishLoading();
                if (value != null && value.size() > 0){
                    mContentBeanList.addAll(value);
                    mRecyclerViewAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onError(Throwable e) {
                //加载失败，关闭加载提示
                mLoadingRefreshLayout.finishLoading();
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public boolean isAllowToIntercept() {
        //自定义的RecyclerView的拦截事件
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


}

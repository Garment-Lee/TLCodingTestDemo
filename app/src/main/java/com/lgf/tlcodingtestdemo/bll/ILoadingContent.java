package com.lgf.tlcodingtestdemo.bll;

import com.lgf.tlcodingtestdemo.bean.ShowingContentBean;

import java.util.ArrayList;

import io.reactivex.Observer;

/**
 * Created by ligf on 2018/5/22.
 */

public interface ILoadingContent {

    void getShowingCityGuideData(String url, Observer<ArrayList<ShowingContentBean>> observer);
}

package com.lgf.tlcodingtestdemo.network.retrofit.service;

import com.lgf.tlcodingtestdemo.network.retrofit.bean.ShowingContentRespBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by garment on 2018/5/21.
 */

public interface LoadingShowingContentService {

    @GET
    Observable<ShowingContentRespBean> loadingCityGuideContent(@Url String url);

    @GET
    Observable<ShowingContentRespBean> loadingShopContent(@Url String url);

    @GET
    Observable<ShowingContentRespBean> loadingEatContent(@Url String url);
}

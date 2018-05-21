package com.lgf.tlcodingtestdemo.bll;

import com.lgf.tlcodingtestdemo.bean.ShowingContentBean;
import com.lgf.tlcodingtestdemo.network.retrofit.RetrofitUtil;
import com.lgf.tlcodingtestdemo.network.retrofit.bean.ShowingContentRespBean;
import com.lgf.tlcodingtestdemo.network.retrofit.service.LoadingShowingContentService;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by garment on 2018/5/20.
 * @description：消息加载业务逻辑管理类
 *
 */

public class LoadingContentBll {

    private static LoadingContentBll instance;

    private LoadingShowingContentService loadingShowingContentService;

    private LoadingContentBll(){
        initService();
    }

    public static LoadingContentBll getInstance(){
        if (instance == null){
            synchronized (LoadingContentBll.class){
                if (instance == null){
                    instance = new LoadingContentBll();
                }
            }
        }
        return instance;
    }

    private void initService(){
        loadingShowingContentService = RetrofitUtil.getInstance().getRetrofit().create(LoadingShowingContentService.class);
    }

    /**
     * 从服务器中获取city guide的内容
     * @param url
     * @param observer
     */
    public void getShowingCityGuideContent(String url, Observer<ArrayList<ShowingContentBean>> observer){
        loadingShowingContentService.loadingCityGuideContent(url)
                .map(new Function<ShowingContentRespBean, ArrayList<ShowingContentBean>>() {
                    @Override
                    public ArrayList<ShowingContentBean> apply(ShowingContentRespBean showingContentRespBean) throws Exception {
                        if (showingContentRespBean.errCode.equals("0")){
                            return showingContentRespBean.data;
                        } else {
                            return null;
                        }
                    }
                })
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

}

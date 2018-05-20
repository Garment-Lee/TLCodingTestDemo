package com.lgf.tlcodingtestdemo.network.retrofit.bean;

import com.lgf.tlcodingtestdemo.bean.ShowingContentBean;

import java.util.ArrayList;

/**
 * Created by garment on 2018/5/20.
 * @description：服务器返回的json数据对应实体类
 */

public class ShowingContentRespBean extends BaseResponseBean {

    /**服务器返回的数据列表*/
     public ArrayList<ShowingContentBean> data;
}

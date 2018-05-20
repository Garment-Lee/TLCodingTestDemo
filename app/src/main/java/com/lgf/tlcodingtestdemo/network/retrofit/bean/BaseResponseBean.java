package com.lgf.tlcodingtestdemo.network.retrofit.bean;

import java.io.Serializable;

/**
 * Created by garment on 2018/5/20.
 */

public class BaseResponseBean implements Serializable {

    /** 错误码*/
    public String errCode;

    /** 错误信息*/
    public String errMsg;
}

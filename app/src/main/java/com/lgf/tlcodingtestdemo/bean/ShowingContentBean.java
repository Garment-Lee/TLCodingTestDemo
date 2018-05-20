package com.lgf.tlcodingtestdemo.bean;

/**
 * Created by garment on 2018/5/20.
 * @description: 用于列表展示的数据实体类
 */

public class ShowingContentBean {

    /**数据类型，0：只有图片的数据；1：既有图片又有描述的数据*/
    public String type;
    /** 标题*/
    public String title;
    /**描述的内容*/
    public String description;
    /**图片的URL*/
    public String imgUrl;
}

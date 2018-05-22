package com.lgf.tlcodingtestdemo.network.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by garment on 2018/5/20.
 * @description:网络请求工具的初始化
 */

public class RetrofitUtil {

    private static RetrofitUtil instance;

    private Retrofit retrofit;

    public static final String BASE_URL = "http://test.lgf.com";

    private RetrofitUtil(){
        init();
    }

    public static RetrofitUtil getInstance(){
        if (instance == null){
            synchronized (RetrofitUtil.class){
                if (instance == null){
                    instance = new RetrofitUtil();
                }
            }
        }
        return instance;
    }

    /**
     * 初始化Retrofit，使用前调用
     */
    private void init(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)  //设置基础请求Url
                .client(myClient()) //Http请求客户端
                .addConverterFactory(GsonConverterFactory.create(myGson()))//序列化和反序列化设置
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //支持Service(Retrofit2)返回Observable(RxJava)
                .build();
    }

    private OkHttpClient myClient() {
        //声明日志类
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        //设定日志级别
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
        return client;
    }

    private Gson myGson() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();
        return gson;
    }

    public Retrofit getRetrofit(){
        return retrofit;
    }


}

package com.lgf.tlcodingtestdemo;

/**
 * Created by ligf on 2018/5/22.
 */

public class RxUniteTextTool {


    private static boolean isInitRxTools = false;

    /**
     * 把异步变成同步，方便测试
     */
    public static void openRxTools() {
        if (isInitRxTools) {
            return;
        }
        isInitRxTools = true;
//        RxAndroidSchedulersHook rxAndroidSchedulersHook = new RxAndroidSchedulersHook() {
//            @Override
//            public Scheduler getMainThreadScheduler() {
//                return Schedulers.immediate();
//            }
//        };
//        RxJavaSchedulersHook rxJavaSchedulersHook = new RxJavaSchedulersHook() {
//            @Override
//            public Scheduler getIOScheduler() {
//                return Schedulers.immediate();
//            }
//        }; // reset()不是必要，实践中发现不写reset()，偶尔会出错，所以写上保险^_^ RxAndroidPlugins.getInstance().reset(); RxAndroidPlugins.getInstance().registerSchedulersHook(rxAndroidSchedulersHook); RxJavaPlugins.getInstance().reset(); RxJavaPlugins.getInstance().registerSchedulersHook(rxJavaSchedulersHook); }

    }
}
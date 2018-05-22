package com.lgf.tlcodingtestdemo.bll;

import com.lgf.tlcodingtestdemo.network.retrofit.service.LoadingShowingContentService;

import org.junit.Before;

import static org.mockito.Mockito.mock;

/**
 * Created by ligf on 2018/5/22.
 */
public class ILoadingContentTest {

    LoadingShowingContentService loadingShowingContentService;
    LoadingContentBll loadingContentBll;

    @Before
    public void setUp() throws Exception{
        loadingShowingContentService = mock(LoadingShowingContentService.class);
    }

}
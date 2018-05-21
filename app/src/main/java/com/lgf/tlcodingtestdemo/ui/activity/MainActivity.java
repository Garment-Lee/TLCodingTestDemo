package com.lgf.tlcodingtestdemo.ui.activity;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.lgf.tlcodingtestdemo.R;
import com.lgf.tlcodingtestdemo.base.BaseActivity;
import com.lgf.tlcodingtestdemo.base.BaseFragment;
import com.lgf.tlcodingtestdemo.ui.fragment.CityGuideFragment;
import com.lgf.tlcodingtestdemo.ui.fragment.EatFragment;
import com.lgf.tlcodingtestdemo.ui.fragment.ShopFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 应用的Activity主界面
 */
public class MainActivity extends BaseActivity {

    /**被选中tab的提示视图*/
    private View indicators[] = new View[3];
    private ViewPager mViewPager;
    private List<BaseFragment> mFragments = new ArrayList<>();
    private PagerAdapter mFragmentPagerAdapter;
    private TextView textViews[] = new TextView[3];

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {
        indicators[0] = findViewById(R.id.indicator_city_guide_tab);
        indicators[1] = findViewById(R.id.indicator_shop_tab);
        indicators[2] = findViewById(R.id.indicator_eat_tab);

        textViews[0] = (TextView) findViewById(R.id.tv_main_activity_city_guide);
        textViews[1] = (TextView) findViewById(R.id.tv_main_activity_shop);
        textViews[2] = (TextView) findViewById(R.id.tv_main_activity_eat);

        mViewPager = (ViewPager) findViewById(R.id.vp_showing_content);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setSelectedIndicator(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mFragments.add(CityGuideFragment.getInstance());
        mFragments.add(ShopFragment.getInstance());
        mFragments.add(EatFragment.getInstance());

        mFragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        };

        mViewPager.setAdapter(mFragmentPagerAdapter);//FragmentPagerAdapter类内的每一个生成的 Fragment都将保存在内存之中

    }

    @Override
    public void initData() {

    }

    /**
     * 刷新选中的视图
     * @param position
     */
    private void setSelectedIndicator(int position){
        for (int i = 0; i < indicators.length; i ++){
            indicators[i].setVisibility(View.GONE);
        }
        indicators[position].setVisibility(View.VISIBLE);

        for(int i = 0; i < textViews.length; i ++){
            textViews[i].setTextColor(getResources().getColor(R.color.color_text_normal));
        }
        textViews[position].setTextColor(getResources().getColor(R.color.color_line));
    }
}

package com.bigsong.viewpagerdemo.traditionnal;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.bigsong.viewpagerdemo.R;

import java.util.ArrayList;
import java.util.List;

public class TraditionalViewPagerAcvitity extends Activity {

    private ViewPager mViewPager;

    private PagerAdapter mAdapter;
    private List<View> mViews;
    private LayoutInflater mInflater;

    private int currentIndex;

    private LinearLayout mTabBtnWeixin;
    private LinearLayout mTabBtnFriend;
    private LinearLayout mTabBtnContact;
    private LinearLayout mTabBtnSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traditional_view_pager_acvitity);
        mInflater = getLayoutInflater().from(this);
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);

        initViews();

        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                resetBtn();
                switch (position) {
                    case 0:
                        ((ImageButton) mTabBtnWeixin.findViewById(R.id.btn_tab_bottom_weixin)).setImageResource(R.drawable.tab_weixin_pressed);
                        break;
                    case 1:
                        ((ImageButton) mTabBtnFriend.findViewById(R.id.btn_tab_bottom_friend)).setImageResource(R.drawable.tab_find_frd_pressed);
                        break;
                    case 2:
                        ((ImageButton) mTabBtnContact.findViewById(R.id.btn_tab_bottom_contact)).setImageResource(R.drawable.tab_address_pressed);
                        break;
                    case 3:
                        ((ImageButton) mTabBtnSetting.findViewById(R.id.btn_tab_bottom_setting)).setImageResource(R.drawable.tab_settings_pressed);
                        break;
                }
                currentIndex = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initViews() {
        mTabBtnWeixin = (LinearLayout) findViewById(R.id.id_tab_bottom_weixin);
        mTabBtnFriend = (LinearLayout) findViewById(R.id.id_tab_bottom_friend);
        mTabBtnContact = (LinearLayout) findViewById(R.id.id_tab_bottom_contact);
        mTabBtnSetting = (LinearLayout) findViewById(R.id.id_tab_bottom_setting);
        mViews = new ArrayList<View>();
        View first = mInflater.inflate(R.layout.main_tab_01, null);
        View second = mInflater.inflate(R.layout.main_tab_02, null);
        View third = mInflater.inflate(R.layout.main_tab_03, null);
        View fourth = mInflater.inflate(R.layout.main_tab_04, null);
        mViews.add(first);
        mViews.add(second);
        mViews.add(third);
        mViews.add(fourth);
        mAdapter = new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = mViews.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mViews.get(position));
            }

            @Override
            public int getCount() {
                return mViews.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        };
    }

    private void resetBtn() {
        ((ImageButton) mTabBtnWeixin.findViewById(R.id.btn_tab_bottom_weixin)).setImageResource(R.drawable.tab_weixin_normal);
        ((ImageButton) mTabBtnFriend.findViewById(R.id.btn_tab_bottom_friend)).setImageResource(R.drawable.tab_find_frd_normal);
        ((ImageButton) mTabBtnContact.findViewById(R.id.btn_tab_bottom_contact)).setImageResource(R.drawable.tab_address_normal);
        ((ImageButton) mTabBtnSetting.findViewById(R.id.btn_tab_bottom_setting)).setImageResource(R.drawable.tab_settings_normal);
    }

}

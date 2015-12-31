package com.bigsong.viewpagerdemo.fragmentAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.bigsong.viewpagerdemo.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentAdapterMainActivity extends FragmentActivity {
    private LinearLayout mTabWinxin;
    private LinearLayout mTabFriend;
    private LinearLayout mTabContact;
    private LinearLayout mTabSetting;

    private ViewPager mViewPager;
    private List<Fragment> fragmentList = new ArrayList<Fragment>();
    private FragmentPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traditional_view_pager_acvitity);
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        mTabWinxin = (LinearLayout) findViewById(R.id.id_tab_bottom_weixin);
        mTabFriend = (LinearLayout) findViewById(R.id.id_tab_bottom_friend);
        mTabContact = (LinearLayout) findViewById(R.id.id_tab_bottom_contact);
        mTabSetting = (LinearLayout) findViewById(R.id.id_tab_bottom_setting);
        MainTab01 tab01 = new MainTab01();
        MainTab02 tab02 = new MainTab02();
        MainTab03 tab03 = new MainTab03();
        MainTab04 tab04 = new MainTab04();
        fragmentList.add(tab01);
        fragmentList.add(tab02);
        fragmentList.add(tab03);
        fragmentList.add(tab04);
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };
        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ((ImageButton) mTabWinxin.findViewById(R.id.btn_tab_bottom_weixin)).setImageResource(R.drawable.tab_weixin_normal);
                ((ImageButton) mTabFriend.findViewById(R.id.btn_tab_bottom_friend)).setImageResource(R.drawable.tab_find_frd_normal);
                ((ImageButton) mTabContact.findViewById(R.id.btn_tab_bottom_contact)).setImageResource(R.drawable.tab_address_normal);
                ((ImageButton) mTabSetting.findViewById(R.id.btn_tab_bottom_setting)).setImageResource(R.drawable.tab_settings_normal);
                switch (position) {
                    case 0:
                        ((ImageButton) mTabWinxin.findViewById(R.id.btn_tab_bottom_weixin)).setImageResource(R.drawable.tab_weixin_pressed);
                        break;
                    case 1:
                        ((ImageButton) mTabFriend.findViewById(R.id.btn_tab_bottom_friend)).setImageResource(R.drawable.tab_find_frd_pressed);
                        break;
                    case 2:
                        ((ImageButton) mTabContact.findViewById(R.id.btn_tab_bottom_contact)).setImageResource(R.drawable.tab_address_pressed);
                        break;
                    case 3:
                        ((ImageButton) mTabSetting.findViewById(R.id.btn_tab_bottom_setting)).setImageResource(R.drawable.tab_settings_pressed);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}

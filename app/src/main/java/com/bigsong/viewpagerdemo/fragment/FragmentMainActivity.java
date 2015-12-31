package com.bigsong.viewpagerdemo.fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.bigsong.viewpagerdemo.R;

public class FragmentMainActivity extends Activity implements View.OnClickListener {

    private MainTab01 mTab01;
    private MainTab02 mTab02;
    private MainTab03 mTab03;
    private MainTab04 mTab04;

    private LinearLayout mTabWinxin;
    private LinearLayout mTabFriend;
    private LinearLayout mTabContact;
    private LinearLayout mTabSetting;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);
        mTabWinxin = (LinearLayout) findViewById(R.id.id_tab_bottom_weixin);
        mTabFriend = (LinearLayout) findViewById(R.id.id_tab_bottom_friend);
        mTabContact = (LinearLayout) findViewById(R.id.id_tab_bottom_contact);
        mTabSetting = (LinearLayout) findViewById(R.id.id_tab_bottom_setting);
        mTabWinxin.setOnClickListener(this);
        mTabFriend.setOnClickListener(this);
        mTabContact.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);
        fragmentManager = getFragmentManager();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_tab_bottom_weixin:
                setTabSelection(0);
                break;
            case R.id.id_tab_bottom_friend:
                setTabSelection(1);
                break;
            case R.id.id_tab_bottom_contact:
                setTabSelection(2);
                break;
            case R.id.id_tab_bottom_setting:
                setTabSelection(3);
                break;
        }
    }

    private void setTabSelection(int index) {
        ((ImageButton) mTabWinxin.findViewById(R.id.btn_tab_bottom_weixin)).setImageResource(R.drawable.tab_weixin_normal);
        ((ImageButton) mTabFriend.findViewById(R.id.btn_tab_bottom_friend)).setImageResource(R.drawable.tab_find_frd_normal);
        ((ImageButton) mTabContact.findViewById(R.id.btn_tab_bottom_contact)).setImageResource(R.drawable.tab_address_normal);
        ((ImageButton) mTabSetting.findViewById(R.id.btn_tab_bottom_setting)).setImageResource(R.drawable.tab_settings_normal);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (index) {
            case 0:
                ((ImageButton) mTabWinxin.findViewById(R.id.btn_tab_bottom_weixin)).setImageResource(R.drawable.tab_weixin_pressed);
                if (mTab01 == null) {
                    mTab01 = new MainTab01();
                    transaction.add(R.id.id_content, mTab01);
                } else {
                    transaction.show(mTab01);
                }
                break;
            case 1:
                ((ImageButton) mTabFriend.findViewById(R.id.btn_tab_bottom_friend)).setImageResource(R.drawable.tab_find_frd_pressed);
                if (mTab02 == null) {
                    mTab02 = new MainTab02();
                    transaction.add(R.id.id_content, mTab02);
                } else {
                    transaction.show(mTab02);
                }
                break;
            case 2:
                ((ImageButton) mTabContact.findViewById(R.id.btn_tab_bottom_contact)).setImageResource(R.drawable.tab_address_pressed);
                if (mTab03 == null) {
                    mTab03 = new MainTab03();
                    transaction.add(R.id.id_content, mTab03);
                } else {
                    transaction.show(mTab03);
                }
                break;
            case 3:
                ((ImageButton) mTabSetting.findViewById(R.id.btn_tab_bottom_setting)).setImageResource(R.drawable.tab_settings_pressed);
                if (mTab04 == null) {
                    mTab04 = new MainTab04();
                    transaction.add(R.id.id_content, mTab04);
                } else {
                    transaction.show(mTab04);
                }
                break;
        }
        transaction.commit();
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (mTab01 != null) {
            transaction.hide(mTab01);
        }
        if (mTab02 != null) {
            transaction.hide(mTab02);
        }
        if (mTab03 != null) {
            transaction.hide(mTab03);
        }
        if (mTab04 != null) {
            transaction.hide(mTab04);
        }
    }
}

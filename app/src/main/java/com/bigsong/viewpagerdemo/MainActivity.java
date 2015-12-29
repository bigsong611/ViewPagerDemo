package com.bigsong.viewpagerdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.bigsong.viewpagerdemo.traditionnal.TraditionalViewPagerAcvitity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends Activity {
    private ListView mListView;
    private ArrayAdapter<String> mAdapter;
    private List<String> mData = new ArrayList<String>(Arrays.asList("Traditional ViewPager" , "FragmentManager & Fragment"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.id_listview);
        mAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mData);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (position){
                    case 0:
                        intent = new Intent(MainActivity.this, TraditionalViewPagerAcvitity.class);
                        break;
                }
                startActivity(intent);
            }
        });
    }


}

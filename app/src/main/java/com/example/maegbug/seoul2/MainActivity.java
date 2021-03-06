package com.example.maegbug.seoul2;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

package pager.view.tap.tablayouts;



public class MainActivity extends AppCompatActivity {



    TabLayout sliding_tab;

    ViewPager pager;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        sliding_tab = (TabLayout) findViewById(R.id.sliding_tabs);

        pager = (ViewPager) findViewById(R.id.viewPager);

        pager.setAdapter(new FragmentAdpater(getSupportFragmentManager()));

        pager.setOffscreenPageLimit(2); // 안보이는 페이지 로딩해 놓을 갯수

        sliding_tab.addTab(sliding_tab.newTab().setText("tab1"), 0, true); // 페이지 등록

        sliding_tab.addTab(sliding_tab.newTab().setText("tab2"), 1);



        sliding_tab.addOnTabSelectedListener(pagerListener);

        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(sliding_tab));

    }



    TabLayout.OnTabSelectedListener pagerListener = new TabLayout.OnTabSelectedListener() {

        @Override

        public void onTabSelected(TabLayout.Tab tab) {

            pager.setCurrentItem(tab.getPosition());

            // 슬라이딩이 아니라 위에 페이지를 선택했을 때도 페이지 이동 가능하게.

        }

        @Override

        public void onTabUnselected(TabLayout.Tab tab) { }

        @Override

        public void onTabReselected(TabLayout.Tab tab) { }

    };

}




package com.dsm2018.dms_meal.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.dsm2018.dms_meal.DateAdder;
import com.dsm2018.dms_meal.Fragment_meal;
import com.dsm2018.dms_meal.Fragment_meal1;
import com.dsm2018.dms_meal.Fragment_meal2;
import com.dsm2018.dms_meal.Fragment_meal3;
import com.dsm2018.dms_meal.Fragment_meal4;
import com.dsm2018.dms_meal.Fragment_meal5;
import com.dsm2018.dms_meal.Fragment_meal6;
import com.dsm2018.dms_meal.R;

public class MainActivity extends AppCompatActivity {
    ViewPager vp;           //vp를 ViewPager 로 설정
    int Max_Page = 30;   //총 1주일 7페이지

    DateAdder date = new DateAdder();   //DateAdder 객체
    Fragment_meal fragment_meal= new Fragment_meal(date.Date(0), date.Year(), date.Month_day(0), date.Week_of_Day(0));
    Fragment_meal1 fragment_meal1 = new Fragment_meal1(date.Date(1), date.Year(), date.Month_day(1), date.Week_of_Day(1));
    Fragment_meal2 fragment_meal2 = new Fragment_meal2(date.Date(2), date.Year(), date.Month_day(2), date.Week_of_Day(2));
    Fragment_meal3 fragment_meal3 = new Fragment_meal3(date.Date(3), date.Year(), date.Month_day(3), date.Week_of_Day(3));
    Fragment_meal4 fragment_meal4 = new Fragment_meal4(date.Date(4), date.Year(), date.Month_day(4), date.Week_of_Day(4));
    Fragment_meal5 fragment_meal5 = new Fragment_meal5(date.Date(5), date.Year(), date.Month_day(5), date.Week_of_Day(5));
    Fragment_meal6 fragment_meal6 = new Fragment_meal6(date.Date(6), date.Year(), date.Month_day(6), date.Week_of_Day(6));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp=(ViewPager)findViewById(R.id.pager);                 //ViewPager 위치 설정
        vp.setAdapter(new adapter(getSupportFragmentManager()));    //Fragment 를 사용하기위한 Manager 활용
        vp.setCurrentItem(0);

    }

    private class adapter extends FragmentPagerAdapter {
        public adapter(FragmentManager fm) {
            super(fm);
        }       //Fragment 연결
        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            if(position<0 || Max_Page<=position)    //position 이 설정 범위 벗어날 시 null 값 return
                return null;

            switch (position){
                case 0:
                    return fragment_meal;
                case 1:
                    return fragment_meal1;
                case 2:
                    return fragment_meal2;
                case 3:
                    return fragment_meal3;
                case 4:
                    return fragment_meal4;
                case 5:
                    return fragment_meal5;
                case 6:
                    return fragment_meal6;
            }
            return null;
        }
        @Override
        public int getCount() {
            return Max_Page;
        }   //Count 는 최대 페이지
    }
}
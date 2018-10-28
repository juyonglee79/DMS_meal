package com.dsm2018.dms_meal;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dsm2018.dms_meal.Connector.Connector;

@SuppressLint("ValidFragment")
public class Fragment_meal4 extends android.support.v4.app.Fragment{

    String date;
    String year;
    String month_day;
    String week_of_day;


    @SuppressLint("ValidFragment")
    public Fragment_meal4(String date, String year, String month_day, String week_of_day) {
        this.date = date;
        this.year = year;
        this.month_day = month_day;
        this.week_of_day = week_of_day;
    }


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getValue();

        View view = inflater.inflate(R.layout.activity_item, container, false);     //전체 View

        TextView breakfast = (TextView)view.findViewById(R.id.morning_meal);
        breakfast.setText(Connector.getBreakfast());
        TextView lunch = (TextView) view.findViewById(R.id.lunch_meal);
        lunch.setText(Connector.getLunch());
        TextView dinner = (TextView)view.findViewById(R.id.dinner_meal);
        dinner.setText(Connector.getDinner());
        TextView month_daytextview = (TextView) view.findViewById(R.id.month);
        month_daytextview.setText(month_day);
        TextView yeartextview = (TextView)view.findViewById(R.id.year);
        yeartextview.setText(year);
        TextView week_of_daytextview = (TextView) view.findViewById(R.id.day_of_the_week);
        week_of_daytextview.setText(week_of_day);                                       //요일 날짜 표현

        return view;        //변경한 view return
    }

    public void getValue() {
        Connector connector = new Connector();
        connector.init(date);
    }

}

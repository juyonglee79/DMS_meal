package com.dsm2018.dms_meal.Connector;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Connector {

    static String breakfast;
    static String lunch;                                               //static 을 이용하여 동적이 아닌 정적 변수 선언
    static String dinner;

    public static String getBreakfast() {
        return breakfast;
    }

    public static String getLunch() {                                       //static 을 이용하여 정적 메소드
        return lunch;
    }

    public static String getDinner() {
        return dinner;
    }

    public void init(String date) {

        String baseUrl = "http://dsm2015.cafe24.com/v2/";          //값을 가져올 baseUrl 설정
        API mTestService = ServiceGenerator.createService(API.class);

        Call<Model> call = mTestService.getMeal(date);           //ApiService 에 받아온 date(날짜)양식 입력
        Log.v("date", date);                                 //날짜 Log.v로 확인
        final String stringDate = date;

        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                Log.d("Success date", stringDate);

                if (response.isSuccessful()) {                      //정보를 성공적으로 불러왔다면
                    Log.v("success", "성공");
                    Model body = response.body();                   //받아온 정보를 model 로 body 에 가져옴
                    breakfast = body.breakfast.toString();
                    breakfast = breakfast.replace("[", "");        //List 타입으로 인해 남아있던 []삭제
                    breakfast = breakfast.replace("]", "");
                    lunch = body.lunch.toString();                  //아침 점심 저녁 따로 분리하여 String 형식으로 대입
                    lunch = lunch.replace("[", "");
                    lunch = lunch.replace("]", "");
                    dinner = body.dinner.toString();
                    dinner = dinner.replace("[", "");
                    dinner = dinner.replace("]", "");
                } else {
                    Log.e("errorBody()", response.errorBody().toString());  //error 가 났다면 error 가 난 부분 Log.e표시
                }
            }


            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.e("Failure date", stringDate);

                Log.e("오류 발생", t.getMessage());             //오류나면 메시지 Log.e에서 확인
                t.printStackTrace();
            }
        });

    }
}


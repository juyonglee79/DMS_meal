package com.dsm2018.dms_meal.Connector;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface API {
    @GET("/v2/meal/{date}")
    public Call<Model> getMeal(@Path("date") String date);

}

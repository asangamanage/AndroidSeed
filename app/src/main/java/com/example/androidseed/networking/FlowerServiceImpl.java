package com.example.androidseed.networking;

import com.example.androidseed.models.Flower;
import com.example.androidseed.networking.retrofit.FlowerRestService;

import java.io.IOException;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by asangamanage on 7/07/2016.
 */
public class FlowerServiceImpl implements FlowerService {
    static String flowersUrl = "http://services.hanselandpetal.com/feeds/";

    private FlowerRestService flowerRestService;

    private FlowerRestService getRetroFitService() {

        if (flowerRestService == null) {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(flowersUrl).addConverterFactory(GsonConverterFactory.create()).build();
            flowerRestService = retrofit.create(FlowerRestService.class);
        }
        return flowerRestService;
    }

    @Override
    public void getFlowers(Callback<List<Flower>> callback) throws IOException {
        getRetroFitService().listFlowers().enqueue(callback);
    }
}

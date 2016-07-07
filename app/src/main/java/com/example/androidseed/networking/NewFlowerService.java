package com.example.androidseed.networking;

import com.example.androidseed.models.Flower;
import com.example.androidseed.networking.retrofit.FlowerRestService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by asangamanage on 7/07/2016.
 */
public class NewFlowerService implements FlowerService {
    static String flowersUrl = "http://services.hanselandpetal.com/feeds/";

    @Override
    public Call<List<Flower>> getFlowers() throws IOException {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(flowersUrl).addConverterFactory(GsonConverterFactory.create()).build();
        FlowerRestService flowerRestService = retrofit.create(FlowerRestService.class);
        return flowerRestService.listFlowers();
    }
}

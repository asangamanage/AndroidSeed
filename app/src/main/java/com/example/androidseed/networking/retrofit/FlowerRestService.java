package com.example.androidseed.networking.retrofit;

import com.example.androidseed.models.Flower;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by asangamanage on 7/07/2016.
 */
public interface FlowerRestService {
    @GET("flowers.json")
    Call<List<Flower>> listFlowers();
}

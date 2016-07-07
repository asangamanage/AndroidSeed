package com.example.androidseed.networking;

import com.example.androidseed.models.Flower;

import java.io.IOException;
import java.util.List;

import retrofit2.Callback;

/**
 * Created by asangamanage on 19/05/2016.
 */
public interface FlowerService {
    void getFlowers(Callback<List<Flower>> callback) throws IOException;
}

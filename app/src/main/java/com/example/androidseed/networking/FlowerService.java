package com.example.androidseed.networking;

import com.example.androidseed.models.Flower;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Created by asangamanage on 19/05/2016.
 */
public interface FlowerService {
    Call<List<Flower>> getFlowers() throws IOException;
}

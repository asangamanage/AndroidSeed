package com.example.androidseed.networking;

import com.example.androidseed.models.Flower;

import java.io.IOException;
import java.util.List;

/**
 * Created by asangamanage on 19/05/2016.
 */
public interface FlowerService {
    List<Flower> getFlowers() throws IOException;
}

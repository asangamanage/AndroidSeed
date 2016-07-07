package com.example.androidseed.networking;

import com.example.androidseed.models.Flower;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * Created by asangamanage on 18/05/2016.
 */
public class FlowerServiceImpl implements FlowerService {

    static String flowersUrl = "http://services.hanselandpetal.com/feeds/flowers.json";

    public List<Flower> getFlowers() throws IOException {
        InputStream is = null;
        try {
            URL url = new URL(flowersUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();
            is = conn.getInputStream();
            Reader reader = new InputStreamReader(is);
            Gson gson = new Gson();
            Flower[] flowerResponse = gson.fromJson(reader, Flower[].class);
            return Arrays.asList(flowerResponse);
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }
}

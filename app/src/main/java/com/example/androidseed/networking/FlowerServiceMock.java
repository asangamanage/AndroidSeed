package com.example.androidseed.networking;

import com.example.androidseed.models.Flower;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by asangamanage on 19/05/2016.
 */
public class FlowerServiceMock implements FlowerService {
    @Override
    public List<Flower> getFlowers() throws IOException {
        List<Flower> flowers = new ArrayList<>();
        flowers.add(new Flower(1, "Shrubs", 15.99, "Large double. Good grower, heavy bloomer. Early to mid-season, acid loving plants. Plant in moist well drained soil with pH of 4.0-5.5.", "california_snow.jpg", "Azalea", "http://services.hanselandpetal.com/photos/california_snow.jpg"));
        flowers.add(new Flower(2, "Shrubs", 13.99, "Beautiful large royal purple flowers adorn attractive satiny green leaves that turn orange\\/red in cold weather. Grows to up to 18 feet, or prune annually to shorten.", "princess_flower.jpg", "Tibouchina Semidecandra", "http://services.hanselandpetal.com/photos/princess_flower.jpg"));
        flowers.add(new Flower(3, "Shrubs", 12.99, "BBlooms in summer, 20-35 inches high. Fertilize regularly for best results. Full sun, drought tolerant.", "haight_ashbury.jpg", "Hibiscus", "http://services.hanselandpetal.com/photos/haight_ashbury.jpg"));
        return flowers;
    }
}

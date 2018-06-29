package com.example.moonmayor.imagelistviews.mockdata;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by moonmayor on 10/5/17.
 */

public class UnsplashImages {
    public static final String image1 = "https://images.unsplash.com/photo-1426604966848-d7adac402bff?dpr=1&auto=compress,format&fit=crop&w=1500&h=&q=80&cs=tinysrgb&crop=";
    public static final String image2 = "https://images.unsplash.com/photo-1498857006179-0ab79e24640b?dpr=1&auto=compress,format&fit=crop&w=668&h=&q=80&cs=tinysrgb&crop=";
    public static final String image3 = "https://images.unsplash.com/photo-1473042904451-00171c69419d?dpr=1&auto=compress,format&fit=crop&w=2875&h=&q=80&cs=tinysrgb&crop=";
    public static final String image4 = "https://images.unsplash.com/photo-1505845297973-ae7a996087c4?dpr=1&auto=compress,format&fit=crop&w=2980&h=&q=80&cs=tinysrgb&crop=";
    public static final String image5 = "https://images.unsplash.com/photo-1494825253165-ea450b5d5231?dpr=1&auto=compress,format&fit=crop&w=750&h=&q=80&cs=tinysrgb&crop=";
    public static final String image6 = "https://images.unsplash.com/photo-1496748161186-63985e911efc?dpr=1&auto=compress,format&fit=crop&w=1492&h=&q=80&cs=tinysrgb&crop=";
    public static final String image7 = "https://images.unsplash.com/photo-1495420378468-78588a508652?dpr=1&auto=compress,format&fit=crop&w=1500&h=&q=80&cs=tinysrgb&crop=";

    public static final List<String> allUrls = new ArrayList<>();

    // remember what random image we spat out last so the never one is spat twice in a row.
    private static int lastRandomIndex = -1;

    static {
        allUrls.add(image1);
        allUrls.add(image2);
        allUrls.add(image3);
        allUrls.add(image4);
        allUrls.add(image5);
        allUrls.add(image6);
        allUrls.add(image7);
    }

    public static String randomUrl() {
        int index = lastRandomIndex;
        while (index == UnsplashImages.lastRandomIndex) {
            index = (int) Math.floor(Math.random() * allUrls.size());
        }

        // be sure to remember what index we just chose.
        lastRandomIndex = index;

        String randomUrl = allUrls.get(index);
        return randomUrl;
    }
}

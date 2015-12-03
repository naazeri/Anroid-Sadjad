package com.example.reza.mediaplayer;


import java.util.ArrayList;
import java.util.List;

public class DataManager {

    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("آهنگ ۱", R.drawable.image1));
        items.add(new Item("آهنگ ۲", R.drawable.image2));
        items.add(new Item("آهنگ ۳", R.drawable.image1));
        items.add(new Item("آهنگ ۴", R.drawable.image2));

        return items;
    }

}

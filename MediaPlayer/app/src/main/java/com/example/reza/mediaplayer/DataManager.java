package com.example.reza.mediaplayer;


import java.util.ArrayList;
import java.util.List;

public class DataManager {

    public List<Item> getItems() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("آهنگ ۱", R.drawable.image1, R.raw.sound1));
        items.add(new Item("آهنگ ۲", R.drawable.image2, R.raw.sound2));
        items.add(new Item("آهنگ ۳", R.drawable.image3, R.raw.sound3));

        return items;
    }

}

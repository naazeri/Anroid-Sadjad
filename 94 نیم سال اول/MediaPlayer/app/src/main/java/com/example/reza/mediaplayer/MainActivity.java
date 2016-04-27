package com.example.reza.mediaplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            DataManager dataManager = new DataManager();
            list = (ListView) findViewById(R.id.listView);
            ListAdapter adapter = new ListAdapter(MainActivity.this, dataManager.getItems());
            list.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }

    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//
//        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
//            mediaPlayer.pause();
//        }
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//
//        if(mediaPlayer != null) {
//            mediaPlayer.stop();
//        }
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//
//        mediaPlayer.release();
//    }
}

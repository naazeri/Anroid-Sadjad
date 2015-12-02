package com.example.reza.mediaplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    Button playButton;
//    SeekBar seekBar;
//    MediaPlayer mediaPlayer;
//    Handler handler;
//    Runnable runnable;
    static ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        try {
            List<String> stringList = new ArrayList<>();
            stringList.add("مشهد");
            stringList.add("تهران");
            stringList.add("نیشابور");
            stringList.add("اصفهان");
            stringList.add("یزد");

            list = (ListView) findViewById(R.id.listView);
            ListAdapter adapter = new ListAdapter(MainActivity.this, stringList);
            list.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }


//        playButton = (Button) findViewById(R.id.button2);
//        seekBar = (SeekBar) findViewById(R.id.seekBar);
//
//        playButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.music);
//                mediaPlayer.start();
//            }
//        });
//
//        handler = new Handler();
//
//        runnable = new Runnable() {
//            @Override
//            public void run() {
//                float time = mediaPlayer.getCurrentPosition() / mediaPlayer.getDuration() * 100;
//                seekBar.setProgress((int)time);
//
//                handler.postDelayed(runnable, 300);
//            }
//        };
//
//        handler.postDelayed(runnable, 300);

    }

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

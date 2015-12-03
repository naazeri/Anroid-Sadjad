package com.example.reza.mediaplayer;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    Button playButton;
//    SeekBar seekBar;
//    MediaPlayer mediaPlayer;
//    Handler handler;
//    Runnable runnable;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ActionBar actionBar = getActionBar();
        BitmapDrawable background = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.image1));
        background.setTileModeX(android.graphics.Shader.TileMode.REPEAT);
        actionBar.setBackgroundDrawable(background);

//        try {
//            DataManager dataManager = new DataManager();
//            list = (ListView) findViewById(R.id.listView);
//            ListAdapter adapter = new ListAdapter(MainActivity.this, dataManager.getItems());
//            list.setAdapter(adapter);
//        } catch (Exception e) {
//            e.printStackTrace();
//            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
//        }


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
//
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

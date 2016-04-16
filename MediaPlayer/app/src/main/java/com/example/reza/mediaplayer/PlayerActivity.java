package com.example.reza.mediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class PlayerActivity extends AppCompatActivity {

    Button stopButton;
    SeekBar seekBar;
    TextView musicName_textView;
    ImageView musicImage_imageView;
    MediaPlayer mediaPlayer;
    Handler handler;
    Runnable runnable;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        stopButton = (Button) findViewById(R.id.player_stopBtn);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        musicImage_imageView = (ImageView) findViewById(R.id.player_musicImage);
        musicName_textView = (TextView) findViewById(R.id.player_musicName);

        bundle = getIntent().getExtras();
        String musicName = bundle.getString("musicName", "Blank");
        int musicImage = bundle.getInt("musicImage");
        int musicAddress = bundle.getInt("musicAddress");

        musicName_textView.setText(musicName);
        musicImage_imageView.setBackgroundResource(musicImage);


        mediaPlayer = MediaPlayer.create(PlayerActivity.this, musicAddress);
        mediaPlayer.start();

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                float time = mediaPlayer.getCurrentPosition() / mediaPlayer.getDuration() * 100;
                seekBar.setProgress((int)time);

                handler.postDelayed(runnable, 300);
            }
        };

        handler.postDelayed(runnable, 300);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }
}

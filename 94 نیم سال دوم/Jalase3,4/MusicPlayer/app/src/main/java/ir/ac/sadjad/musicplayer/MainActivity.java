package ir.ac.sadjad.musicplayer;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String[] colorList = new String[]{"#F44336", "#795548", "#3F51B5", "#009688", "#FFC107"};
    private Spinner color_spinner;
    private Button changeColor_button, clear_button, pic1_button, pic2_button, pic3_button, play_button, pause_button;
    private TextView outputText_textView;
    private EditText inputText_editText;
    private ImageView image;
    private SeekBar seekBar;
    private MediaPlayer mediaPlayer;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            initView();
            initListeners();
            initSpinner();
            initMediaPlayer();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, R.string.errorInLoadData, Toast.LENGTH_SHORT).show();
        }
    }

    private void initView() {
        changeColor_button = (Button) findViewById(R.id.main_button_changeColor);
        clear_button = (Button) findViewById(R.id.main_button_clear);
        pic1_button = (Button) findViewById(R.id.main_button_setPic1);
        pic2_button = (Button) findViewById(R.id.main_button_setPic2);
        pic3_button = (Button) findViewById(R.id.main_button_setPic3);
        play_button = (Button) findViewById(R.id.main_button_play);
        pause_button = (Button) findViewById(R.id.main_button_pause);
        color_spinner = (Spinner) findViewById(R.id.main_spinner_colors);
        seekBar = (SeekBar) findViewById(R.id.main_seekBar);
        outputText_textView = (TextView) findViewById(R.id.main_textView_outputText);
        inputText_editText = (EditText) findViewById(R.id.main_editText_inputText);
        image = (ImageView) findViewById(R.id.main_imageView_image);
    }

    private void initListeners() {
        changeColor_button.setOnClickListener(this);
        clear_button.setOnClickListener(this);
        pic1_button.setOnClickListener(this);
        pic2_button.setOnClickListener(this);
        pic3_button.setOnClickListener(this);
        play_button.setOnClickListener(this);
        pause_button.setOnClickListener(this);
    }

    private void initSpinner() {
        ArrayAdapter<String> colorAdapter;
//        colorAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, colorList);
//        colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        colorAdapter = new ArrayAdapter<String>(this, R.layout.spinner_current_item, colorList);
        colorAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

        color_spinner.setAdapter(colorAdapter);
    }

    private void initMediaPlayer() {
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.sound_01);
        handler = new Handler();
    }

    private void startPlayer() {
        if (mediaPlayer == null) {
            Toast.makeText(MainActivity.this, "MediaPlayer not initialize", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
            seekBar.setMax(mediaPlayer.getDuration());
            handler.postDelayed(updateSongTime, 100);
        }
    }

    private void pausePlayer() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            handler.removeCallbacks(updateSongTime);
        }
    }

    private void stopPlayer() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            handler.removeCallbacks(updateSongTime);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.main_button_changeColor:
                changeTextColor();
                break;
            case R.id.main_button_clear:
                inputText_editText.setText("");
                break;
            case R.id.main_button_setPic1:
                break;
            case R.id.main_button_setPic2:
                break;
            case R.id.main_button_setPic3:
                break;
            case R.id.main_button_play:
                startPlayer();
                break;
            case R.id.main_button_pause:
                pausePlayer();
                break;
            default:
                break;
        }
    }

    private void changeTextColor() {
        String colorString = color_spinner.getSelectedItem().toString();
        int color = Color.parseColor(colorString);
        outputText_textView.setTextColor(color);
    }

    private Runnable updateSongTime = new Runnable() {
        @Override
        public void run() {
            seekBar.setProgress(mediaPlayer.getCurrentPosition());
            handler.postDelayed(this, 100);
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        pausePlayer();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopPlayer();
    }
}

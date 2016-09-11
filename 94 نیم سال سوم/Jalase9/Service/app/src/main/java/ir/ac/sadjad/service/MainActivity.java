package ir.ac.sadjad.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button start_button, stop_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start_button = (Button) findViewById(R.id.main_button_start);
        stop_button = (Button) findViewById(R.id.main_button_stop);


        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TimerService.class);
                startService(intent);
            }
        });


        stop_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TimerService.class);
                stopService(intent);
            }
        });
    }
}

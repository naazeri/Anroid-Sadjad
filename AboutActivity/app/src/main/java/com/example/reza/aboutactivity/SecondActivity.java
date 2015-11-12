package com.example.reza.aboutactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textView;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = (TextView) findViewById(R.id.textView);

        bundle = getIntent().getExtras();

        if (bundle.containsKey("name") && bundle.containsKey("family")) {
            String name, family;
            name = bundle.getString("name");
            family = bundle.getString("family");

            textView.setText("Hi " + name + " " + family);
        }

        else {
            textView.setText("Blank");
        }
    }
}

package com.example.reza.splash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.tumblr.remember.Remember;

public class ShowDataActivity extends AppCompatActivity {

    TextView name_textView, family_textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        Remember.init(getApplicationContext(), getPackageName());

        name_textView = (TextView) findViewById(R.id.showdata_textView_name);
        family_textView = (TextView) findViewById(R.id.showdata_textView_family);

        String name, family;

        name = Remember.getString("name", "خالی");
        family = Remember.getString("family", "خالی");

        name_textView.setText(name);
        family_textView.setText(family);
    }

}

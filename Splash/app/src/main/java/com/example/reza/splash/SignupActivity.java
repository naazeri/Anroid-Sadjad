package com.example.reza.splash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tumblr.remember.Remember;

public class SignupActivity extends AppCompatActivity {

    EditText name_editText, family_editText;
    Button submit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Remember.init(getApplicationContext(), getPackageName());

        name_editText = (EditText) findViewById(R.id.singup_editText_name);
        family_editText = (EditText) findViewById(R.id.signup_editText_family);
        submit_button = (Button) findViewById(R.id.signup_button_submit);

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, family;
                name = name_editText.getText().toString();
                family = family_editText.getText().toString();

                Remember.putString("name", name);
                Remember.putString("family", family);
            }
        });
    }
}

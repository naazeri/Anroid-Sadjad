package com.example.reza.aboutactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name_editText, family_editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_editText = (EditText) findViewById(R.id.editText_name);
        family_editText = (EditText) findViewById(R.id.editText_family);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

                String name, family;
                name = name_editText.getText().toString();
                family = family_editText.getText().toString();

                intent.putExtra("name", name);
                intent.putExtra("family", family);

                startActivity(intent);
            }
        });
    }
}

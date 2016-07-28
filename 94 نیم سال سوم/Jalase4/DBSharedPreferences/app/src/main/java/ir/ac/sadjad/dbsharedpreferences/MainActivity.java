package ir.ac.sadjad.dbsharedpreferences;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button save_button, load_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Remember.init(MainActivity.this, getPackageName());

        save_button = (Button) findViewById(R.id.main_button_save);
        load_button = (Button) findViewById(R.id.main_button_load);

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Remember.putString("nameKey", "Sadjad");
                Toast.makeText(MainActivity.this, "ذخیره شد", Toast.LENGTH_SHORT).show();
            }
        });

        load_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = Remember.getString("nameKey", "خالی");
                Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

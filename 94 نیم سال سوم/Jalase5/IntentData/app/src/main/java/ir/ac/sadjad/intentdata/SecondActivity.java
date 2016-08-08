package ir.ac.sadjad.intentdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView output_textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        output_textView = (TextView) findViewById(R.id.second_textView_output);

        String data = getIntent().getStringExtra(MainActivity.INTENT_DATA);

        output_textView.setText(data);
    }
}

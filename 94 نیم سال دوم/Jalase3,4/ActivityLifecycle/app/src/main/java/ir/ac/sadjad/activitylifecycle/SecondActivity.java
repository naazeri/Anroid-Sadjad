package ir.ac.sadjad.activitylifecycle;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        textView = (TextView) findViewById(R.id.second_textView_text);
//
//        Typeface font = Typeface.createFromAsset(getAssets(), "");
//        textView.setTypeface(font);
    }
}

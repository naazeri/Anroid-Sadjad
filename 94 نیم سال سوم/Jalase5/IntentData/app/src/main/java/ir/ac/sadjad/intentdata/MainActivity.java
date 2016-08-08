package ir.ac.sadjad.intentdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText input_editText;
    Button submit_button;
    public static final String INTENT_DATA = "intentData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_editText = (EditText) findViewById(R.id.main_editText_input);
        submit_button = (Button) findViewById(R.id.main_button_submit);

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                /** store data in intent **/
                String data = input_editText.getText().toString();
                intent.putExtra(INTENT_DATA, data);

                startActivity(intent);
            }
        });
    }
}

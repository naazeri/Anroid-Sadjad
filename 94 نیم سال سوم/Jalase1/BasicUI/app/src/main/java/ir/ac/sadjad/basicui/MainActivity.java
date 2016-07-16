package ir.ac.sadjad.basicui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /** UI variables **/
    EditText input_editText;
    TextView output_textView;
    Button apply_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_editText = (EditText) findViewById(R.id.main_editText_input);
        output_textView = (TextView) findViewById(R.id.main_textView_output);
        apply_button = (Button) findViewById(R.id.main_button_apply);


        apply_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = input_editText.getText().toString();
                output_textView.setText(input);
            }
        });
    }
}

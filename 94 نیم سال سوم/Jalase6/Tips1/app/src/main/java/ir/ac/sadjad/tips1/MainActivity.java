package ir.ac.sadjad.tips1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            return;
        }

        Toast.makeText(MainActivity.this, "OnCreate", Toast.LENGTH_SHORT).show();

        editText = (EditText) findViewById(R.id.input);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    plusPlus();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void plusPlus() throws Exception {
        Integer num = Integer.valueOf(editText.getText().toString());
        num++;
        editText.setText(num.toString());
    }
}

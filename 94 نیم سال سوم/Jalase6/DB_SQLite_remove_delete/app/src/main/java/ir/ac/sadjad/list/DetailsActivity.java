package ir.ac.sadjad.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailsActivity extends AppCompatActivity {

    EditText bookName_editText;
    Button update_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        bookName_editText = (EditText) findViewById(R.id.details_editText_input);
        update_button = (Button) findViewById(R.id.details_button_submit);

        String data = getIntent().getStringExtra("book_name");
        final Integer id = getIntent().getIntExtra("id", -1);
        bookName_editText.setText(data);

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Model model = new Model();
                model.setBookName(bookName_editText.getText().toString());
                model.setId(id);

                DataManager dataManager = new DataManager();
                dataManager.updateDB(DetailsActivity.this, model);
                onBackPressed();
            }
        });
    }
}

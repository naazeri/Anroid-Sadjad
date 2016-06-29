package ir.ac.sadjad.librarybooks;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddBookActivity extends AppCompatActivity {

    @Bind(R.id.addBook_editText_bookName)
    EditText bookName_editText;
    @Bind(R.id.addBook_editText_bookCount)
    EditText bookCount_editText;

    @OnClick(R.id.addBook_button_submit)
    public void saveBook() {
        String bookName = bookName_editText.getText().toString();
        Integer bookCount = Integer.valueOf(bookCount_editText.getText().toString());

        Intent resultIntent = new Intent();
        resultIntent.putExtra("bookName", bookName);
        resultIntent.putExtra("bookCount", bookCount);

        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        ButterKnife.bind(this);
    }
}

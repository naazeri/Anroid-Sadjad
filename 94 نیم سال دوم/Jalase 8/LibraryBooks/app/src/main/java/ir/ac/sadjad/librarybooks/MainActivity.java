package ir.ac.sadjad.librarybooks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ir.ac.sadjad.librarybooks.database.DataManager;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_ADD_BOOK = 1;
    private DataManager dataManager;

    @OnClick(R.id.main_button_showBookList)
    public void showBookList() {
        Intent intent = new Intent(this, BookListActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.main_button_addBook)
    public void showAddBook() {
        Intent intent = new Intent(this, AddBookActivity.class);
        startActivityForResult(intent, REQUEST_ADD_BOOK);
    }

    @OnClick(R.id.main_button_searchBook)
    public void showSearchBook() {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataManager = new DataManager();
        boolean needShow = dataManager.needShowSplash(this);
        if (needShow) {
            Intent intent = new Intent(this, SplashActivity.class);
            startActivity(intent);
            dataManager.setSplashStatus(false);
        }

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_ADD_BOOK) {
                String bookName = data.getStringExtra("bookName");
                Integer bookCount = data.getIntExtra("bookCount", -1);

                dataManager.saveBook(this, bookName, bookCount);
            }
        }
    }
}

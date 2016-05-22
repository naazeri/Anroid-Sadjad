package ir.ac.sadjad.librarybooks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ir.ac.sadjad.librarybooks.database.DataManager;

public class MainActivity extends AppCompatActivity {

    private int count = 0;

    @OnClick(R.id.main_button_showBookList)
    public void showBookList() {
        Intent intent = new Intent(this, BookListActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DataManager dataManager = new DataManager();
        boolean needShow = dataManager.needShowSplash(this);
        if (needShow) {
            Intent intent = new Intent(this, SplashActivity.class);
            startActivity(intent);
            dataManager.setSplashStatus(false);
        }

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

}

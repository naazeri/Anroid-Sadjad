package ir.ac.sadjad.librarybooks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import ir.ac.sadjad.librarybooks.adapter.BookListAdapter;
import ir.ac.sadjad.librarybooks.database.DataManager;

public class BookListActivity extends AppCompatActivity {

    private DataManager dataManager;

    @Bind(R.id.bookList_recyclerView)
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        dataManager = new DataManager();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> list = dataManager.getBookList(this);
        BookListAdapter adapter = new BookListAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}

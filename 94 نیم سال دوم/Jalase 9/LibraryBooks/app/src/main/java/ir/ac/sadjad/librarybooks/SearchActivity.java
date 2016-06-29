package ir.ac.sadjad.librarybooks;

import android.app.SearchManager;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ir.ac.sadjad.librarybooks.adapter.BookListAdapter;
import ir.ac.sadjad.librarybooks.database.DataManager;
import ir.ac.sadjad.librarybooks.model.ModelBook;

public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private List<ModelBook> list;
    private BookListAdapter adapter;

    @Bind(R.id.search_recyclerView)
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.search_toolbar);
        setSupportActionBar(toolbar);

        /*** add search bar ***/

        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        DataManager dataManager = new DataManager();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = dataManager.getBookList(this);
        adapter = new BookListAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_menu, menu);

        // Retrieve the SearchView and plug it into SearchManager
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.d("searchTag", "onQueryTextSubmit: " + query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        final List<ModelBook> filteredModelList = filter(list, newText);
        adapter.setModel(filteredModelList);
        recyclerView.scrollToPosition(0);
        return true;
    }

    private List<ModelBook> filter(List<ModelBook> models, String query) {
        final List<ModelBook> filteredModelList = new ArrayList<>();
        for (ModelBook model : models) {
            String bookName = model.getBookName();
            if (bookName.contains(query)) {
                filteredModelList.add(model);
            }
        }

        return filteredModelList;
    }
}

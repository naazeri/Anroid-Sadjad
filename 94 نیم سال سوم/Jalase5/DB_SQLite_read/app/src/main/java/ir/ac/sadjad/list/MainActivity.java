package ir.ac.sadjad.list;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.main_recyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        List<String> list = getListData();
        ListAdapter adapter = new ListAdapter(R.layout.row_list, list);
        recyclerView.setAdapter(adapter);
    }

    private List<String> getListData() {
        List<String> list = new ArrayList<>();

        DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
        SQLiteDatabase database = databaseHelper.getReadableDatabase();

//        Cursor cursor = database.rawQuery("SELECT book_name FROM books", null);

        String tableName = "books";
        String[] columns = {"book_name"};
        Cursor cursor = database.query(tableName, columns, null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                /** get data **/
                String book = cursor.getString(cursor.getColumnIndex("book_name"));

                /** add data to list**/
                list.add(book);
            } while (cursor.moveToNext());

            cursor.close();
        }

        database.close();
        return list;
    }
}

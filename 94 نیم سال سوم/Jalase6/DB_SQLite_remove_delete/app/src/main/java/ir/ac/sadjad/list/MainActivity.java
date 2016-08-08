package ir.ac.sadjad.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EditText input_editText;
    private Button submit_button;
    private ListAdapter adapter;
    private List<Model> list;
    private DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.main_recyclerView);
        input_editText = (EditText) findViewById(R.id.main_editText_input);
        submit_button = (Button) findViewById(R.id.main_button_submit);

        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        dataManager = new DataManager();

        View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                int position = recyclerView.getChildLayoutPosition(view);
                Model model = list.get(position);
                adapter.removeItem(model);
                dataManager.removeFromDB(MainActivity.this, model);
                return true;
            }
        };

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = recyclerView.getChildLayoutPosition(view);

                Model model = list.get(position);
                String bookName = model.getBookName();
                Integer id = model.getId();

                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("book_name", bookName);
                intent.putExtra("id", id);

                startActivity(intent);
            }
        };

        list = dataManager.getListData(MainActivity.this);
        adapter = new ListAdapter(R.layout.row_list, list, longClickListener, clickListener);
        recyclerView.setAdapter(adapter);


        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Model model = new Model();
                model.setBookName(input_editText.getText().toString());
                adapter.addItem(model);
                dataManager.saveInDB(MainActivity.this, model);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        list = dataManager.getListData(MainActivity.this);
        adapter.setList(list);
    }
}

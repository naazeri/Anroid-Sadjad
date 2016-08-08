package ir.ac.sadjad.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    EditText input_editText;
    Button submit_button;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.main_recyclerView);
        input_editText = (EditText) findViewById(R.id.main_editText_input);
        submit_button = (Button) findViewById(R.id.main_button_submit);

        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


        View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                int position = recyclerView.getChildLayoutPosition(view);
                adapter.removeItem(position);
                return true;
            }
        };

        List<String> list = getListData();
        adapter = new ListAdapter(R.layout.row_list, list, longClickListener);
        recyclerView.setAdapter(adapter);


        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = input_editText.getText().toString();
                adapter.addItem(data);
            }
        });
    }

    private List<String> getListData() {
        List<String> list = new LinkedList<>();
        return list;
    }
}

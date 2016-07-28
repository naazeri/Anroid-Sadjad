package ir.ac.sadjad.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.text.MessageFormat;
import java.util.LinkedList;
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
        List<String> list = new LinkedList<>();

        for (int i = 0; i < 30; i++) {
            list.add("سطر " + (i + 1));
//            list.add(String.format("سطر %d", i + 1));
//            list.add(MessageFormat.format("سطر {0}", i + 1));
        }

        return list;
    }
}

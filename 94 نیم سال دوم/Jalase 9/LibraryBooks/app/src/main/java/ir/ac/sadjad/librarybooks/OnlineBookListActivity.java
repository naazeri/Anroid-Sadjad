package ir.ac.sadjad.librarybooks;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import butterknife.ButterKnife;
import ir.ac.sadjad.librarybooks.adapter.BookListAdapter;
import ir.ac.sadjad.librarybooks.database.DataManager;
import ir.ac.sadjad.librarybooks.model.ModelBook;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OnlineBookListActivity extends AppCompatActivity {

    @Bind(R.id.onlineBookList_recyclerView)
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_book_list);

        ButterKnife.bind(this);
        getDataFromServer(getString(R.string.server_address));
    }

    private void getDataFromServer(String url) {
        Callback callback = new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(OnlineBookListActivity.this, "خطا در دریافت اطلاعات از سرور", Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful() && response.code() == 200) {
                    String data = response.body().string();
                    final List<ModelBook> list = decodeJson(data);

                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            initView(list);
                        }
                    });
                }
            }
        };

        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .connectTimeout(8000, TimeUnit.MILLISECONDS)
                .readTimeout(8000, TimeUnit.MILLISECONDS)
                .writeTimeout(8000, TimeUnit.MILLISECONDS)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(callback);
    }

    private List<ModelBook> decodeJson(String data) {
        List<ModelBook> list = new LinkedList<>();

        try {
            JSONArray jsonArray = new JSONArray(data);
            for (int i = 0; i < jsonArray.length(); i++) {
                ModelBook book = new ModelBook();
                book.setBookName(jsonArray.getString(i));
                book.setCount(-1);
                list.add(book);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }

    private void initView(List<ModelBook> list) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        BookListAdapter adapter = new BookListAdapter(list, R.layout.row_booklist);
        recyclerView.setAdapter(adapter);
    }
}

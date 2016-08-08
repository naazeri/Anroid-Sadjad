package ir.ac.sadjad.onlinelist;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getDataFromServer("http://json-pyreza.rhcloud.com/");
    }

    private void initView(List<String> list) {
        recyclerView = (RecyclerView) findViewById(R.id.main_recyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        ListAdapter adapter = new ListAdapter(R.layout.row_list, list);
        recyclerView.setAdapter(adapter);
    }

    private void getDataFromServer(String url) {
        Callback callback = new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        /** show a message in main thread **/
                        Toast.makeText(MainActivity.this, "خطا در دریافت اطلاعات از سرور", Toast.LENGTH_LONG).show();
                    }
                });

                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful() && response.code() == 200) {
                    /** get data **/
                    String data = response.body().string();

                    /** convert JSON to List **/
                    final List<String> list = decodeJson(data);

                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            /** create UI in main thread **/
                            initView(list);
                        }
                    });
                }
            }
        };

        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .connectTimeout(7000, TimeUnit.MILLISECONDS)
                .readTimeout(7000, TimeUnit.MILLISECONDS)
                .writeTimeout(7000, TimeUnit.MILLISECONDS)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(callback);
    }

    private List<String> decodeJson(String data) {
        List<String> list = new LinkedList<>();

        try {
            JSONObject json = new JSONObject(data);
            JSONArray week = json.getJSONArray("week");
            for (int i = 0; i < week.length(); i++) {
                String s = week.getString(i);
                list.add(s);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }
}

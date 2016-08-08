package ir.ac.sadjad.post;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    EditText input_editText;
    TextView output_textView;
    Button apply_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_editText = (EditText) findViewById(R.id.main_editText_input);
        output_textView = (TextView) findViewById(R.id.main_textView_output);
        apply_button = (Button) findViewById(R.id.main_button_apply);

        apply_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sendData = input_editText.getText().toString();
                if (sendData.equals("0")) {
                    sendData = "00";
                }
                sendDataToServer("http://jsontest.cloudsite.ir/post.php", sendData);
            }
        });

    }

    private void sendDataToServer(String url, String sendData) {
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
                    final String data = response.body().string();

                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            /** create UI in main thread **/
                            output_textView.setText(data);
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

        RequestBody formBody = new FormBody.Builder()
                .add("number", sendData)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();

        client.newCall(request).enqueue(callback);
    }
}

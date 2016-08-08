package ir.ac.sadjad.asynctask;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button turnon_button, turnoff_button;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        turnon_button = (Button) findViewById(R.id.main_button_turnon);
        turnoff_button = (Button) findViewById(R.id.main_button_turnoff);
        progressBar = (ProgressBar) findViewById(R.id.main_progressBar);

        turnon_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LongWork longWork = new LongWork();
                longWork.execute(true);
            }
        });

        turnoff_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LongWork longWork = new LongWork();
                longWork.execute(false);
            }
        });
    }

    private class LongWork extends AsyncTask<Boolean, Integer, String> {

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Boolean... params) {
            boolean status = params[0];

            publishProgress(30);
            WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
            publishProgress(60);
            wifiManager.setWifiEnabled(status);
            publishProgress(90);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return "fail";
            }
            publishProgress(100);
            return "ok";
        }

        @Override
        protected void onPostExecute(String result) {
            progressBar.setVisibility(View.INVISIBLE);

            if (result.equals("ok")) {
                Toast.makeText(MainActivity.this, "با موفقیت انجام شد", Toast.LENGTH_LONG).show();
            } else if (result.equals("fail")) {
                Toast.makeText(MainActivity.this, "خطا در انجام عملیات", Toast.LENGTH_LONG).show();
            }
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            int a = values[0];
        }
    }
}

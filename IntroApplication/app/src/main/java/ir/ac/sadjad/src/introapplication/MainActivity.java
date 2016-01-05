package ir.ac.sadjad.src.introapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.orhanobut.hawk.Hawk;
import com.orhanobut.hawk.HawkBuilder;
import com.orhanobut.hawk.LogLevel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        showIntro();

//        setContentView(R.layout.activity_main);

    }

    private void showIntro() {
        try {
            Hawk.init(MainActivity.this)
                    .setEncryptionMethod(HawkBuilder.EncryptionMethod.MEDIUM)
                    .setPassword("password")
                    .setStorage(HawkBuilder.newSharedPrefStorage(this))
                    .setLogLevel(LogLevel.NONE)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("sharedpref", "exception", e);
        }


        boolean show = Hawk.get("showIntro", true);
        if (show) {
            startActivity(new Intent(this, Intro.class));
        }
    }
}

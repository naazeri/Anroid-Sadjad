package ir.ac.sadjad.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class TimerService extends Service {

    private Handler handler;
    private Runnable runnable;
    private Integer second;

    public TimerService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Toast.makeText(TimerService.this, "Service Start", Toast.LENGTH_SHORT).show();


        runnable = new Runnable() {
            @Override
            public void run() {
                second += 4;
                Toast.makeText(TimerService.this, "Sec: " + second, Toast.LENGTH_SHORT).show();

                if (second >= 16) {
                    handler.removeCallbacks(this);
                    stopSelf();
                } else {
                    handler.postDelayed(this, 4000);
                }
            }
        };

        second = 0;
        handler = new Handler();
        handler.postDelayed(runnable, 4000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        handler.removeCallbacks(runnable);

        Toast.makeText(TimerService.this, "Service Stop", Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

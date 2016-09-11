package ir.ac.sadjad.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BatteryReceiver extends BroadcastReceiver {
    public BatteryReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "شارژر متصل شد", Toast.LENGTH_LONG).show();
    }
}

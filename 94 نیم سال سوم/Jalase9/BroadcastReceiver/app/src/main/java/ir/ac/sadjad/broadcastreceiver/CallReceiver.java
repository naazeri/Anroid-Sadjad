package ir.ac.sadjad.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import java.lang.reflect.Method;

public class CallReceiver extends BroadcastReceiver {

    public CallReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            String number = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            Toast.makeText(context, "Call: " + number, Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "خطا", Toast.LENGTH_LONG).show();
        }

    }

    /*private void rejectCall(Context context) throws Exception {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

        // Get the getITelephony() method
        Class<?> classTelephony = Class.forName(telephonyManager.getClass().getName());
        Method method = classTelephony.getDeclaredMethod("getITelephony");

        // Disable access check
        method.setAccessible(true);

        // Invoke getITelephony() to get the ITelephony interface
        Object telephonyInterface = method.invoke(telephonyManager);

        // Get the endCall method from ITelephony
        Class<?> telephonyInterfaceClass = Class.forName(telephonyInterface.getClass().getName());
        Method methodEndCall = telephonyInterfaceClass.getDeclaredMethod("endCall");

        // Invoke endCall()
        methodEndCall.invoke(telephonyInterface);
    }*/
}

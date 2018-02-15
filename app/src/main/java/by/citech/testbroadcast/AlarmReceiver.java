package by.citech.testbroadcast;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("COMM", "Pre");
        Intent i = new Intent(context, MyService.class);
        context.startService(i);

        Log.d("COMM","Pos");

    }
}

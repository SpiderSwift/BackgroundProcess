package by.citech.testbroadcast;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.format.Time;
import android.util.Log;
import android.widget.Toast;


public class BootBroadcastReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        //IntentService sticky


        Log.e("com", "Booting up ");

        Intent i = new Intent(context,MyService.class);
        context.startService(i);



        //Intent alarmIntent = new Intent(context, AlarmReceiver.class);
        //Log.e("intent", alarmIntent.toString());
//        Intent activity = new Intent(context, MainActivity.class);
//        activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(activity);

        //PendingIntent pi = PendingIntent.getBroadcast(context, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        //AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        //Log.e("tag", am.toString());


        //am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 8000, pi);


        Log.e("com", "Booted up ");
    }
}

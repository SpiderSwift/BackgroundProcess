package by.citech.testbroadcast;


import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class HideNotificationService extends Service {


    static final int NOTIFICATION_ID = 543;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher_background);
        Notification notification;
        notification = builder.getNotification();

        startForeground(NOTIFICATION_ID, notification);
        stopForeground(true);
    }

}

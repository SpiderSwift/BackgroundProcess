package by.citech.testbroadcast;



import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyService extends Service {
    static final int NOTIFICATION_ID = 543;

    public static boolean isServiceRunning = false;
    public static ServerSocket serverSocket;

    @Override
    public void onCreate() {
        super.onCreate();
        startServiceWithNotification();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String data = intent.getDataString();
        if (data != null && data.equals("destroy")) {
            stopMyService();
        } else {
            startServiceWithNotification();
        }
        return START_STICKY;
    }

    // In case the service is deleted or crashes some how
    @Override
    public void onDestroy() {
        isServiceRunning = false;
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // Used only in case of bound services.
        return null;
    }


    void startServiceWithNotification() {
        System.out.println("called service... STATUS :" + isServiceRunning);
        if (isServiceRunning) {
            return;
        }


        new Thread(new Runnable() {
            @Override
            public void run() {
                if (serverSocket == null) {
                    try {
                        serverSocket = new ServerSocket(8080);
                        Socket socket = serverSocket.accept();
                        System.out.println("Connected: " + socket.toString() + socket.getInputStream().read());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        isServiceRunning = true;
        Notification notification = new NotificationCompat.Builder(this).build();
        startForeground(NOTIFICATION_ID, notification);
//        Intent hideIntent = new Intent(this, HideNotificationService.class);
//        startService(hideIntent);
    }

    void stopMyService() {
        stopForeground(false);
        stopSelf();
        isServiceRunning = false;
    }
}









//public class MyService extends IntentService {
//
//    public MyService() {
//        super("test-service");
//    }
//
//
//
//    @Override
//    protected void onHandleIntent(@Nullable Intent intent) {
//        Handler mHandler = new Handler(getMainLooper());
//        mHandler.post(new Runnable() {
//            @Override
//            public void run() {
//                Toast.makeText(getApplicationContext(), "test", Toast.LENGTH_LONG).show();
               // Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//                System.out.println("called service");
////                Intent notificationIntent = new Intent(getApplicationContext(), MainActivity.class);
////                notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
////
////                TaskStackBuilder stackBuilder = TaskStackBuilder.create(getApplicationContext());
////                stackBuilder.addParentStack(MainActivity.class);
////                stackBuilder.addNextIntent(notificationIntent);
////
////                PendingIntent pendingIntent = stackBuilder.getPendingIntent(
////                        0, PendingIntent.FLAG_UPDATE_CURRENT);
////
//                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
//                Notification notification = builder.setContentTitle("Title")
//                        .setContentText("content").setAutoCancel(true)
//                        .setSmallIcon(R.mipmap.ic_launcher_round)
//                        .setContentIntent(pendingIntent).build();
////
////                NotificationManager notificationManager = (NotificationManager)
////                        getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
////                notificationManager.notify(0, notification);
//
//            }
//        });
//        System.out.println("called on handle");
//    }
//
//
//    @Override
//    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
//        return START_STICKY;
//    }
//
//
//
//}

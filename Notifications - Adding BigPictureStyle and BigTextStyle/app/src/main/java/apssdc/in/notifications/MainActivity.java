package apssdc.in.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendNotification(View view) {
        // Notification Manager is responsible to send or cancel Notifications
        NotificationManager notificaitonManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Let's build the Notifications
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            // Create A notificaiton Channel (its mandatory on devices that are based on API LEVEL 26 and Above)
            NotificationChannel nc = new NotificationChannel("first_notification",
                    "First Notification Channel",NotificationManager.IMPORTANCE_HIGH);
            notificaitonManager.createNotificationChannel(nc);
        }

        NotificationCompat.Builder builder
                = new NotificationCompat.Builder(this,"first_notification");
        builder.setSmallIcon(R.drawable.camera);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.notify);
        builder.setLargeIcon(bitmap);
        builder.setContentTitle("This is the First Notification");
        builder.setContentText("Sample Message");
        builder.setPriority(NotificationCompat.PRIORITY_MAX);

        Intent intent = new Intent(MainActivity.this,MainActivity.class);
        PendingIntent pi = PendingIntent.
                getActivity(this,43,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pi);
        builder.setAutoCancel(true);
        builder.addAction(R.drawable.camera,"Reply",pi);
        Bitmap bmap = BitmapFactory.decodeResource(getResources(),R.drawable.taj);
        /*builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bmap));*/
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText("This is an example" +
                "for Big Text Style. Gmail uses this styling to display the contents of the" +
                "email."));

        // Issue a notification
        notificaitonManager.notify(42,builder.build());
    }
}
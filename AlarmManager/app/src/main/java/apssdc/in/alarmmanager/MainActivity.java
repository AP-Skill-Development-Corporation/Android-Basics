package apssdc.in.alarmmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setAlarm(View view)
    {
        AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);

        PendingIntent pi =
                PendingIntent.getBroadcast(
                        this,
                        23,
                        new Intent(this,AlarmReceiver.class),
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        alarm.setInexactRepeating(AlarmManager.ELAPSED_REALTIME,
                SystemClock.elapsedRealtime(),
                2*1000,
                pi);

    }
}
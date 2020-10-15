package apssdc.in.foregroundservices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startForegroundService(View view) {
        Intent intent = new Intent(this,ForegroundService.class);
        startService(intent);
    }


    public void stopForegroundService(View view) {
        Intent intent =new Intent(this, ForegroundService.class);
        stopService(intent);
    }
}
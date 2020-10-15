package apssdc.in.custombroadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    public static final String CUSTOM_BROADCAST = "apssdc.in.custombroadcastreceiver.APPLICATION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.message);

    }

    public void sendBroadcast(View view) {
        Intent i = new Intent();
        i.setAction(CUSTOM_BROADCAST);
        sendBroadcast(i);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter(CUSTOM_BROADCAST);
        registerReceiver(new CustomReceiver(textView),filter);
    }
}
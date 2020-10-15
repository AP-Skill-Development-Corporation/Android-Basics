package apssdc.in.custombroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CustomReceiver extends BroadcastReceiver {

    TextView textView;

    public CustomReceiver(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
       textView.setText("BROADCAST RECEIVED");
    }
}

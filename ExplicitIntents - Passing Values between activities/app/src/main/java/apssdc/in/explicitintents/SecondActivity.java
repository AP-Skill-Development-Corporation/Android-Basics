package apssdc.in.explicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv = findViewById(R.id.msg);
        // Get the Intent
        Intent in = getIntent();
        // Extract the Value
        String v = in.getStringExtra("VALUE");
        // Display the Data
        tv.setText(v);
    }
}
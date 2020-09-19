package apssdc.in.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        data = findViewById(R.id.data);
        Intent i = getIntent();
        String msg = i.getStringExtra("NAME")+"\n"+i.getIntExtra("AGE",0)+"\n"
                +i.getStringExtra("ADDRESS")+"\n"+i.getStringExtra("GENDER")+"\n"
                +i.getStringExtra("COUNTRY")+"\n"+i.getStringExtra("LANGUAGES");
        data.setText(msg);
    }
}
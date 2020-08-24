package apssdc.in.teamscore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.score);
        if(savedInstanceState!=null){
            // Means we have data
            score = savedInstanceState.getInt("SCORE");
            tv.setText(String.valueOf(score));
        }
    }

    //for first button
    public void decrementScore(View view) {
        score--;
        tv.setText(String.valueOf(score));
    }

    //for Second Button
    public void incrementScore(View view) {
        score++;
        tv.setText(String.valueOf(score));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("SCORE",score); // Stored the data before activity destruction
    }
}
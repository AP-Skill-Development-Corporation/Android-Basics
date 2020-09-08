package apssdc.in.teamscore;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.reset:
                score = 0;
                tv.setText(String.valueOf(score));
                break;
            case R.id.second:
                Toast.makeText(this, "Second Option Selected!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.third:
                Toast.makeText(this, "Third Option Selected!", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
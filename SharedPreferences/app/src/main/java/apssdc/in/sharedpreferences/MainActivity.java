package apssdc.in.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        SharedPreferences.OnSharedPreferenceChangeListener
{

    private EditText dataBox;
    private TextView results;
    // Create a SharedPreferences Object
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataBox = findViewById(R.id.usertext);
        results = findViewById(R.id.results);

        // Initializing the SharedPreferences Object
        preferences = getSharedPreferences("preference",MODE_PRIVATE);

        if(preferences!=null && preferences.contains("TEXT")){
            results.setText(preferences.getString("TEXT",""));
        }

        preferences.registerOnSharedPreferenceChangeListener(this);
    }

    public void saveData(View view)
    {
        // Writing Data to the shared preferences file
        SharedPreferences.Editor editor = preferences.edit();
        String text = dataBox.getText().toString();
        editor.putString("TEXT",text);
        editor.apply();

        dataBox.getText().clear();
        Toast.makeText(this, "Data Is Saved Successfully!", Toast.LENGTH_SHORT).show();

        /*if(preferences!=null && preferences.contains("TEXT")){
            results.setText(preferences.getString("TEXT",""));
        }*/
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        results.setText(sharedPreferences.getString("TEXT",""));
    }
}
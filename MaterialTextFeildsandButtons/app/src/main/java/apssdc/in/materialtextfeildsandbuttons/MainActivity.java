package apssdc.in.materialtextfeildsandbuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saveButton(View view) 
    {
        TextInputLayout textInputLayout = findViewById(R.id.sample);
        String text = textInputLayout.getEditText().getText().toString();
        Toast.makeText(this,text, Toast.LENGTH_SHORT).show();
    }
}
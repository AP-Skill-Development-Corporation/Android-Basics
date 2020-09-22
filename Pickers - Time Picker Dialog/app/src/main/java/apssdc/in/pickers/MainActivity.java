package apssdc.in.pickers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText,editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.datepick);
        editText2 = findViewById(R.id.timepick);
    }

    public void showDatePickerDialog(View view) {
        DialogFragment newFragment = new DatePickerFragment(editText);
        newFragment.show(getSupportFragmentManager(),"date picker");
    }

    public void showTimePickerdialog(View view) {
        DialogFragment newFragment = new TimePickerFragment(editText2);
        newFragment.show(getSupportFragmentManager(),"Time Picker");
    }
}
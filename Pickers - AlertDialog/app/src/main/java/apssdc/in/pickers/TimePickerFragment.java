package apssdc.in.pickers;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener
{

    private EditText editText;

    public TimePickerFragment(EditText editText) {
        this.editText = editText;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR);
        int min = c.get(Calendar.MINUTE);
        return new TimePickerDialog(getActivity(),this,hour,min,false);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        String meridiem = "";
        if(i<12){
            meridiem = "AM";
        }else{
            meridiem = "PM";
            i = i-12;
        }

        int hour = i%12;
        if(hour == 0){
            i = 12;
        }
        editText.setText(i+":"+i1+" "+meridiem);
    }
}

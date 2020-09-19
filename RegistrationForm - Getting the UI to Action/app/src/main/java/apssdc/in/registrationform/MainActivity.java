package apssdc.in.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // The following are the objects for components
    // on activity_main.xml
    private EditText name, age, address;
    private RadioGroup gender;
    private Spinner country;
    private CheckBox english, telugu, hindi;

    // Let's Define Variables that holds the values coming from Views
    private String person_name, person_address, person_gender, person_country,person_languages;
    private int person_age = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiailizeViews();

        country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                person_country = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, person_country, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int itemId = radioGroup.getCheckedRadioButtonId();
                switch (itemId){
                    case R.id.male:
                        person_gender = "MALE";
                        break;
                    case R.id.female:
                        person_gender = "FEMALE";
                        break;
                }
            }
        });
    }

    // This method is intended to initialize Objects
    private void initiailizeViews() {
        //EditTexts
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        address = findViewById(R.id.address);
        //RadioGroup
        gender = findViewById(R.id.gender);
        //Spinner
        country = findViewById(R.id.country);
        //Checkboxes
        english = findViewById(R.id.english);
        telugu = findViewById(R.id.telugu);
        hindi = findViewById(R.id.hindi);
    }

    //This method is going to handle the click events on the button.
    public void goToNext(View view) {
        //COMPLETED Capture All the Values
        person_name = name.getText().toString();
        person_age = Integer.parseInt(age.getText().toString());
        person_address = address.getText().toString();
        person_languages = "";
        if(english.isChecked()){
            person_languages = person_languages + "ENGLISH\n";
        }
        if(telugu.isChecked()){
            person_languages = person_languages + "TELUGU\n";
        }
        if(hindi.isChecked()){
            person_languages = person_languages + "HINDI\n";
        }
        //Completed Send them to the next Screen (ACTIVITY)
        Intent i = new Intent(MainActivity.this,SecondActivity.class);
        i.putExtra("NAME",person_name);
        i.putExtra("AGE",person_age);
        i.putExtra("ADDRESS",person_address);
        i.putExtra("GENDER",person_gender);
        i.putExtra("COUNTRY",person_country);
        i.putExtra("LANGUAGES",person_languages);
        startActivity(i);
    }
}
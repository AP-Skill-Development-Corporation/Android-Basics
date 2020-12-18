package apssdc.in.employeedetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText emp_name, emp_age, emp_salary;
    private RecyclerView recyclerView;
    private DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        helper = new DBHelper(this);
    }
    
    public void loadData(View view) {

    }

    public void saveData(View view) {
        String name = emp_name.getText().toString();
        int age = Integer.parseInt(emp_age.getText().toString());
        int salary = Integer.parseInt(emp_salary.getText().toString());

        ContentValues contentValues = new ContentValues();
        contentValues.put("emp_name",name);
        contentValues.put("emp_age",age);
        contentValues.put("emp_salary",salary);

        helper.insert(contentValues);

        emp_name.getText().clear();
        emp_age.getText().clear();
        emp_salary.getText().clear();
    }

    private void initViews() {
        emp_name = findViewById(R.id.emp_name);
        emp_salary = findViewById(R.id.emp_salary);
        emp_age = findViewById(R.id.emp_age);
        recyclerView = findViewById(R.id.recyclerview);
    }
}
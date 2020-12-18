package apssdc.in.employeedetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class UpdateActivity extends AppCompatActivity {

    private TextView emp_id_update;
    private EditText emp_name_update,emp_age_update,emp_salary_update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        emp_id_update = findViewById(R.id.emp_id_update);
        emp_name_update = findViewById(R.id.emp_name_update);
        emp_age_update = findViewById(R.id.emp_age_update);
        emp_salary_update = findViewById(R.id.emp_salary_update);

        Intent intent = getIntent();
        Employee employee = (Employee) intent.getSerializableExtra("EMP");
        emp_id_update.setText(String.valueOf(employee.getId()));
        emp_name_update.setText(employee.getName());
        emp_age_update.setText(String.valueOf(employee.getAge()));
        emp_salary_update.setText(String.valueOf(employee.getSalary()));

    }

    public void updateValues(View view)
    {
        int id = Integer.parseInt(emp_id_update.getText().toString());
        String name = emp_name_update.getText().toString();
        int age = Integer.parseInt(emp_age_update.getText().toString());
        int salary = Integer.parseInt(emp_salary_update.getText().toString());

        ContentValues values = new ContentValues();
        values.put("emp_id",id);
        values.put("emp_name",name);
        values.put("emp_age",age);
        values.put("emp_salary",salary);

        DBHelper helper = new DBHelper(this);
        helper.update(values);

        finish();
    }
}
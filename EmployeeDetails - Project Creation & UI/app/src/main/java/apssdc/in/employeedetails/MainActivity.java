package apssdc.in.employeedetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText emp_name, emp_age, emp_salary;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    
    public void loadData(View view) {

    }

    public void saveData(View view) {

    }

    private void initViews() {
        emp_name = findViewById(R.id.emp_name);
        emp_salary = findViewById(R.id.emp_salary);
        emp_age = findViewById(R.id.emp_age);
        recyclerView = findViewById(R.id.recyclerview);
    }
}
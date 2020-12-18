package apssdc.in.employeedetails;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "employee.db";
    private Context context;

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Would help us to create Database and tables
        db.execSQL("create table if not exists employee(emp_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "emp_name text, emp_age INTEGER, emp_salary INTEGER);");
        Toast.makeText(context, "DATABASE TABLE CREATED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // Would help us in version management
        db.execSQL("drop table if exists employee");
        onCreate(db);
    }

    public void insert(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("employee", null, contentValues);
        Toast.makeText(context, "INSERTED", Toast.LENGTH_SHORT).show();
        db.close();
    }

    List<Employee> getAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Employee> employees = new ArrayList<>();
        Cursor c = db.rawQuery("select * from employee", null);
        c.moveToFirst();
        do {
            Employee employee = new Employee();
            employee.setId(c.getInt(0));
            employee.setName(c.getString(1));
            employee.setAge(c.getInt(2));
            employee.setSalary(c.getInt(3));
            employees.add(employee);
        } while (c.moveToNext());
        return employees;
    }

    public void delete(Employee employee){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from employee where emp_id = "+employee.getId());
        Toast.makeText(context, "DELETED!", Toast.LENGTH_SHORT).show();
        db.close();
    }

    public void update(ContentValues values){
        SQLiteDatabase db = this.getWritableDatabase();
        String where = "emp_id=?";
        String whereArgs[] = new String[]{String.valueOf(values.get("emp_id"))};
        db.update("employee",values,where,whereArgs);
        db.close();
    }
}

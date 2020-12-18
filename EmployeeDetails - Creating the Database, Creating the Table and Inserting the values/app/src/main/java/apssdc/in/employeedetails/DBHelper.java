package apssdc.in.employeedetails;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper
{

    public static final String DATABASE_NAME = "employee.db";
    private Context context;

    public DBHelper(@Nullable Context context) {
        super(context,DATABASE_NAME, null, 1);
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
    
    public void insert(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("employee",null,contentValues);
        Toast.makeText(context, "INSERTED", Toast.LENGTH_SHORT).show();
    }
}

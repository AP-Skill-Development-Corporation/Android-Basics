package apssdc.in.employeedetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewInformation>
{
    Context context;
    DBHelper helper;
    List<Employee> employees;

    public RecyclerAdapter(Context context, DBHelper helper) {
        this.context = context;
        this.helper = helper;
        employees = helper.getAllData();
    }

    @NonNull
    @Override
    public ViewInformation onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.one_row_design,parent,false);
        return new ViewInformation(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewInformation holder, int position) {
        holder.ename.setText(employees.get(position).getName());
        holder.eage.setText(String.valueOf(employees.get(position).getAge()));
        holder.esalary.setText(String.valueOf(employees.get(position).getSalary()));
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public class ViewInformation extends RecyclerView.ViewHolder {
        TextView ename,eage,esalary;
        Button del_btn;
        public ViewInformation(@NonNull View itemView) {
            super(itemView);
            ename = itemView.findViewById(R.id.emp_name_tv);
            eage = itemView.findViewById(R.id.emp_age_tv);
            esalary = itemView.findViewById(R.id.emp_salary_tv);
            del_btn = itemView.findViewById(R.id.delete_btn);
            del_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Employee emp = employees.get(position);
                    helper.delete(emp);
                    employees.remove(emp);
                    notifyDataSetChanged();
                }
            });
        }
    }
}

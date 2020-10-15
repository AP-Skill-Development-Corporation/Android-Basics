package apssdc.in.covid19updates;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>
{

    private Context context;
    private List<Corona> list;

    public RecyclerAdapter(Context context, List<Corona> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.one_row_design,parent,false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.date.setText(list.get(position).getDate().substring(0,10));
        holder.confirmed.setText("Confirmed\n"+String.valueOf(list.get(position).getConfirmed()));
        holder.recovered.setText("Recovered\n"+String.valueOf(list.get(position).getRecovered()));
        holder.active.setText("Active\n"+String.valueOf(list.get(position).getActive()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder
    {
        TextView date, confirmed, recovered, active;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.corona_date);
            confirmed = itemView.findViewById(R.id.corona_confirmed);
            recovered = itemView.findViewById(R.id.corona_recovered);
            active = itemView.findViewById(R.id.corona_active);
        }
    }
}

package apssdc.in.topmovies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int posters[];
    private String movie_names[];
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        // This method is responsible to create the data
        // for recyclerview.
        setUpData();
        recyclerView.setAdapter(new RecyclerAdapter());
        /*recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));*/
        /*recyclerView.setLayoutManager(new GridLayoutManager(this,2));*/
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
    }

    private void setUpData() {
        posters = new int[]{
                R.drawable.a,
                R.drawable.b,
                R.drawable.c,
                R.drawable.d,
                R.drawable.e,
                R.drawable.f,
                R.drawable.g,
                R.drawable.h,
                R.drawable.i,
                R.drawable.j,
                R.drawable.k,
                R.drawable.l,
                R.drawable.m,
                R.drawable.n,
                R.drawable.o
        };

        movie_names = new String[]{"The Shawshank Redemption","The Godfather",
        "The Dark Knight","The Godfather: Part II","The Lord of the Rings: The Return of the King",
        "Pulp Fiction","Schindler's List","12 Angry Men","Inception","Fight Club",
        "The Lord of the Rings: The Fellowship of the Ring","Forrest Gump","The Good, the Bad and the Ugly",
        "Hamilton","The Lord of the Rings: The Two Towers"};
    }

    class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecylerViewHolder>{

        // This method is responsible to connect the one_row_design.xml
        // to each item in the recyclerview.
        @NonNull
        @Override
        public RecylerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(MainActivity.this).inflate(R.layout.one_row_design
            ,parent,false);
            return new RecylerViewHolder(v);
        }

        // It populates the data on the individual items of the recyclerview
        @Override
        public void onBindViewHolder(@NonNull RecylerViewHolder holder, int position) {
            holder.poster.setImageResource(posters[position]);
            holder.movie.setText(movie_names[position]);
        }

        // This method gives the information about how many total items are present in the
        // recyclerview
        @Override
        public int getItemCount() {
            return posters.length;
        }

        //This class is responsible to connect to the views of each and every layout
        // that is going to be displayed on the recylerview.
        public class RecylerViewHolder extends RecyclerView.ViewHolder {
            ImageView poster;
            TextView movie;
            public RecylerViewHolder(@NonNull View itemView) {
                super(itemView);
                poster = itemView.findViewById(R.id.imageView);
                movie = itemView.findViewById(R.id.textView);
            }
        }
    }
}
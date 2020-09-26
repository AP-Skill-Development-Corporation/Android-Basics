package apssdc.in.topmovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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
}
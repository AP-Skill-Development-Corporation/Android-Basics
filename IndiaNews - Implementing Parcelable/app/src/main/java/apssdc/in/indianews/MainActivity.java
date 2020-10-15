package apssdc.in.indianews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    /*private TextView result;*/
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        progressBar = findViewById(R.id.progressbar);
        /*result = findViewById(R.id.result);*/

        // Creating a Retrofit Object to fetch data
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NewsService newsService = retrofit.create(NewsService.class);
        Call<News> data = newsService.getNews();
        data.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                progressBar.setVisibility(View.GONE);
                News news = response.body();
                List<Article> articles = news.getArticles();
                if(articles.size()>0){
                    /*for(int i=0; i<articles.size(); i++){
                        String title = articles.get(i).getTitle();
                        *//*result.append(title+"\n\n");*//*
                    }*/

                    RecyclerAdapter recyclerAdapter =
                            new RecyclerAdapter(articles);
                    recyclerView.setAdapter(recyclerAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Toast.makeText(MainActivity.this, "failure", Toast.LENGTH_SHORT).show();
            }
        });
    }

    class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{

        List<Article> list;

        public RecyclerAdapter(List<Article> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(MainActivity.this)
                    .inflate(R.layout.one_row_design,parent,false);
            return new RecyclerViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
            holder.news_article.setText(list.get(position).getTitle());
            Glide.with(MainActivity.this).load(list.get(position).getUrlToImage())
                    .into(holder.image_article);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
        {
            TextView news_article;
            ImageView image_article;

            public RecyclerViewHolder(@NonNull View itemView) {
                super(itemView);

                news_article = itemView.findViewById(R.id.news_title);
                image_article = itemView.findViewById(R.id.news_image);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                int position = getAdapterPosition();
                Article article = list.get(position);
                Intent i = new Intent(MainActivity.this,DetailsActivity.class);
                i.putExtra("ARTICLE",article);
                startActivity(i);
            }
        }
    }
}
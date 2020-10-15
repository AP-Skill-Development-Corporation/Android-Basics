package apssdc.in.covid19updates;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private RecyclerView recyclerView;

    /*private TextView result;*/
    private static final String link = "https://api.covid19api.com/total/dayone/country/india";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressbar);
        /*result = findViewById(R.id.result);*/
        recyclerView = findViewById(R.id.recyclerview);
        final Gson gson = new GsonBuilder().create();

        //instantiating Request Queue
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest request = new StringRequest(StringRequest.Method.GET, link,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressBar.setVisibility(View.GONE);
                        /*result.setText(response);*/
                       List<Corona> list = Arrays.asList(gson.fromJson(response,Corona[].class));
                       /*for(int i=0; i<list.size(); i++){
                           *//*result.append("Confirmed "+list.get(i).getConfirmed()+"\n\n");*//*
                       }*/
                        RecyclerAdapter recyclerAdapter =
                                new RecyclerAdapter(MainActivity.this,list);
                        recyclerView.setAdapter(recyclerAdapter);
                        /*recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));*/
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        queue.add(request);
    }
}
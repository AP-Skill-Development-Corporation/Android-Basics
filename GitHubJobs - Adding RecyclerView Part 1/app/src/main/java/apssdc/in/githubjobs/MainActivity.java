package apssdc.in.githubjobs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_LINK =
            "https://jobs.github.com/positions.json?description=";

    private EditText search_query;
    /*private TextView results_text_view;*/
    private ProgressBar progressBar;
    private TextView total_jobs;
    private List<Job> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_query = findViewById(R.id.query);
        /*results_text_view = findViewById(R.id.results);*/
        total_jobs = findViewById(R.id.total_jobs);
        progressBar = findViewById(R.id.progressbar);
        progressBar.setVisibility(View.GONE);
        list = new ArrayList<>();
    }

    public void getData(View view) {
        Toast.makeText(this, "CLICKED", Toast.LENGTH_SHORT).show();
        String q = search_query.getText().toString();
        new FetchJobs().execute(q);
        progressBar.setVisibility(View.VISIBLE);
    }

    class FetchJobs extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(BASE_LINK+strings[0]);
                HttpsURLConnection connection
                        = (HttpsURLConnection) url.openConnection();
                InputStream is = connection.getInputStream();
                if(is!=null){
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);
                    StringBuilder stringBuilder = new StringBuilder();
                    String line = "";
                    while((line=br.readLine())!=null){
                        stringBuilder.append(line);
                    }
                    return stringBuilder.toString();
                }else{
                    Toast.makeText(MainActivity.this, "DATA NOT FOUND", Toast.LENGTH_SHORT).show();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            /*results_text_view.setText(s);*/
            progressBar.setVisibility(View.GONE);

            try {
                JSONArray rootArray = new JSONArray(s);
                total_jobs.setText(rootArray.length()+" Jobs Found");
                for(int i = 0; i<rootArray.length(); i++){
                    JSONObject job = rootArray.getJSONObject(i);
                    String title = job.getString("title");
                    String type = job.getString("type");
                    String company_url = job.getString("company_url");
                    String location = job.getString("location");
                    Job j = new Job(type,company_url,title,location);
                    list.add(j);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
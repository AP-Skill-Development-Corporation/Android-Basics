package apssdc.in.newasynctaskreplacement;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void executeAThread(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final StringBuilder sb = new StringBuilder();
                try {
                    URL url = new URL("https://jsonplaceholder.typicode.com/todos/1");
                    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                    InputStream inputStream = connection.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                    String line = "";
                    while((line=bufferedReader.readLine())!=null){
                        sb.append(line);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, sb.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();
    }
}
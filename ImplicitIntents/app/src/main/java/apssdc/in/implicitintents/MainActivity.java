package apssdc.in.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.url);
        et2 = findViewById(R.id.address);
    }

    public void openBrowser(View view) {
        String u = et.getText().toString();
        if(u.length()!=0){
            // Write the implicit Intent Code
            Intent i = new Intent();
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://"+u));
            startActivity(i);
        }else{
            Toast.makeText(this, "TextField Cannot be Empty", Toast.LENGTH_SHORT).show();
        }
    }

    public void openMaps(View view) {
        String a = et2.getText().toString();
        if(a.length()!=0){
            //write the Implicit Intents code
            Intent i = new Intent();
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("geo:0,0?q="+a));
            startActivity(i);
        }else{
            Toast.makeText(this, "Text Field Cannot be Empty!", Toast.LENGTH_SHORT).show();
        }
    }
}
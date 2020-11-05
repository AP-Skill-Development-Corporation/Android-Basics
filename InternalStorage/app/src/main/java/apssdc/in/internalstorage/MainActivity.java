package apssdc.in.internalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private EditText message;
    private TextView result;
    private FileOutputStream outputStream;
    private FileInputStream inputStream;
    public static final String FILE_NAME = "secret";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = findViewById(R.id.secret_message);
        result = findViewById(R.id.result);

        // The following code is to create a file if not created already. And to open the
        // file
        try {
            outputStream = openFileOutput(FILE_NAME,MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void saveSecret(View view) {
        String secret = message.getText().toString();
        try {
            outputStream.write(secret.getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "SUCCESSFUL", Toast.LENGTH_SHORT).show();
    }

    public void loadSecret(View view) {
        try {
            inputStream = openFileInput(FILE_NAME);
            StringBuffer buffer = new StringBuffer();
            int i;
            while((i = inputStream.read())!=-1){
                buffer.append((char)i);
            }
            result.setText(buffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
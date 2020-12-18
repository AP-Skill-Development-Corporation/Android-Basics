package apssdc.in.externalstorage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private EditText sampleText;
    public static final int PERMISSION_REQUEST_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sampleText = findViewById(R.id.sampletext);
        if(ifPermissionEnabled()){
            Toast.makeText(this, "PERMISSIONS ARE GRANTED!", Toast.LENGTH_SHORT).show();
        }else{
            requestPermission();
        }
    }


    public void saveText(View view) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            ContentResolver resolver = getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put(MediaStore.Downloads.DISPLAY_NAME,"ExternalFile.txt");
            contentValues.put(MediaStore.Downloads.MIME_TYPE,"text/plain");
            contentValues.put(MediaStore.Downloads.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS);
            Uri textUri = resolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI,contentValues);
            OutputStream fos = null;
            try {
                fos = resolver.openOutputStream(Objects.requireNonNull(textUri,sampleText.getText().toString()));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                fos.write(sampleText.getText().toString().getBytes());
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean ifPermissionEnabled(){
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        return false;
    }

    public void requestPermission(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            Toast.makeText(this, "The Permission is Granted", Toast.LENGTH_SHORT).show();
        }else{
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISSION_REQUEST_CODE:
                Toast.makeText(this, "PERMISSION GRANTED", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
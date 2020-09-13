package apssdc.in.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    // Common tag can be used to filter the log messages
    private static final String TAG = "MAINACTIVITY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"OnCreate() method");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart() method");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume() method");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause() method");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop() method");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy() method");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart() method");
    }
}
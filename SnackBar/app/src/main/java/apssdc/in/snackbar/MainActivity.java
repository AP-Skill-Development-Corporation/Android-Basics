package apssdc.in.snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showSnackBar(View view)
    {
        Snackbar
                .make(view,"This is a Sample Snack Bar",Snackbar.LENGTH_INDEFINITE)
                .setAction("Action", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar.make(view,"This is a new Snack Bar",Snackbar.LENGTH_LONG).show();
                    }
                })
                .setAnchorView(view)
                .setActionTextColor(Color.WHITE)
                .show();
    }
}
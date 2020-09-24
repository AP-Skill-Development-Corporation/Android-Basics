package apssdc.in.fruitlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView fruitList;
    private String fruits[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fruitList = findViewById(R.id.fruitlist);
        fruits = new String[]{"Apple", "Banana", "Guava", "Grapes", "Promogranate", "custard Apple",
                "Sapota", "papaya", "Water melon", "Oranges", "Mangoes", "Mosambi", "Dragon Fruit", "Avacado",
                "Peach"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,fruits);
        fruitList.setAdapter(adapter);

        fruitList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
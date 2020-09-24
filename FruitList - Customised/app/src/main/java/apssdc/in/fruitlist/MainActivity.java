package apssdc.in.fruitlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView fruitList;
    private String fruits[];
    private int images[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fruitList = findViewById(R.id.fruitlist);
        fruits = new String[]{"Apple", "Banana", "Guava", "Grapes", "Promogranate", "custard Apple",
                "Sapota", "papaya", "Water melon", "Oranges", "Mangoes", "Mosambi", "Dragon Fruit", "Avacado",
                "Peach"};
        images = new int[]{R.drawable.apple, R.drawable.banana, R.drawable.guava, R.drawable.grapes,
                R.drawable.promegranate, R.drawable.custardapple, R.drawable.sapota, R.drawable.papaya,
                R.drawable.water_melon, R.drawable.orange, R.drawable.mango, R.drawable.mosambi,
                R.drawable.dragon_fruit, R.drawable.avacado, R.drawable.peach};

        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, fruits);*/
        fruitList.setAdapter(new CustomAdapter());

        fruitList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /*String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();*/
                TextView textView = view.findViewById(R.id.fruit_name);
                String item = textView.getText().toString();
                Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();
            }
        });
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.custom_layout,viewGroup,false);
            ImageView fruit_image = view.findViewById(R.id.fruit_image);
            TextView fruit_name = view.findViewById(R.id.fruit_name);

            fruit_image.setImageResource(images[i]);
            fruit_name.setText(fruits[i]);

            return view;
        }
    }
}
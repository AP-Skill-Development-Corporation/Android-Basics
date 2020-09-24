package apssdc.in.demolistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TwoLineListItem;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String names[] = {"PAVAN","MURALI","SHIVA","KIRAN","SUNIL","KALYAN","FIGURE","PAVAN","MURALI","SHIVA","KIRAN","SUNIL","KALYAN","FIGURE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listviews);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return names.length;
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
            view = getLayoutInflater().inflate(R.layout.item_design,null);
            ImageView imageView = view.findViewById(R.id.images);
            TextView textView = view.findViewById(R.id.texts);

            imageView.setImageResource(R.drawable.ic_launcher_background);
            textView.setText(names[i]);
            return view;
        }
    }
}
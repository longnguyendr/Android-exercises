package fi.jamk.phonemodels;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // find list view
        ListView listview = (ListView) findViewById(R.id.listView);

        // generate some dummy data
        String[] phones = new String[]{
                "Android", "iPhone", "WindowsMobile", "Blackberry", "WebOS", "Ubuntu",
                "Android", "iPhone", "WindowsMobile", "Blackberry", "WebOS", "Ubuntu"
        };

        // add data to ArrayList
        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < phones.length; ++i) {
            list.add(phones[i]);
        }

        // add data to ArrayAdapter (default Android ListView style/layout)
        // ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.rowlayout, R.id.textView, list);

        // create custom adapter
        PhoneArrayAdapter adapter = new PhoneArrayAdapter(this, list);

        // set data to listView with adapter
        listview.setAdapter(adapter);

        //item listener
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int index, long id) {
                //get list row data
                String phone = list.get(index);
                //create an explicit intent
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("phone", phone);
                //start new activity, pass the value
                startActivity(intent);
            }
        });
    }
}

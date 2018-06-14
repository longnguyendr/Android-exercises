package fi.jamk.shoppinglist;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;



    public class MainActivity extends AppCompatActivity implements AddShopppingListDialogFragment.DialogListener {
        private final String DATABASE_TABLE = "shoppinglist";
        private final int DELETE_ID = 0;
        private SQLiteDatabase db;
        private Cursor cursor;
        private ListView listView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            // find list view
            listView = (ListView)  findViewById(R.id.listView);
            // register listView's context menu (to delete row)
            registerForContextMenu(listView);

            // get database instance
            db = (new DatabaseOpenHelper(this)).getWritableDatabase();
            // get data with own made queryData method
            queryData();

            // calculate total prices in shoppinglist
            float total = 0f;
            if (cursor.moveToFirst()) {
                do {
                    int count = cursor.getInt(2);
                    float price = cursor.getFloat(3); // columnIndex
                    total += price*count;
                } while(cursor.moveToNext());
                Toast.makeText(getBaseContext(), "Total prices: " + total, Toast.LENGTH_LONG).show();
            }
        }

        // query data from database
        public void queryData() {

            // get data with query
            String[] resultColumns = new String[]{"_id","product","count","price"};
            cursor = db.query(DATABASE_TABLE,resultColumns,null,null,null,null,"price DESC",null);

            // add data to adapter
            ListAdapter adapter = new SimpleCursorAdapter(this, R.layout.list_item, cursor, new String[] {"product", "count", "price"}, new int[] {R.id.product, R.id.count, R.id.price},0);  // flags

            // show data in listView
            listView.setAdapter(adapter);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        // Handles item selections
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_add:
                    AddShopppingListDialogFragment eDialog = new AddShopppingListDialogFragment();
                    eDialog.show(getFragmentManager(), "Add a new Product");
            }
            return false;
        }

        @Override
        public void onDialogPositiveClick(DialogFragment dialog, String product, int count, float price) {
            ContentValues values=new ContentValues(3);
            values.put("product", product);
            values.put("count", count);
            values.put("price",price);
            db.insert("shoppinglist", null, values);
            // get data again
            queryData();

            float total = 0f;
            if (cursor.moveToFirst()) {
                do {
                    count = cursor.getInt(2);
                    price = cursor.getFloat(3); // columnIndex
                    total += price*count;
                } while(cursor.moveToNext());
                Toast.makeText(getBaseContext(), "Total prices: " + total, Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onDialogNegativeClick(DialogFragment dialog) {
            Toast.makeText (getApplicationContext(), "Cancel", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.add(Menu.NONE, DELETE_ID, Menu.NONE, "Delete");
        }

        @Override
        public boolean onContextItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case DELETE_ID:
                    AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
                    String[] args = {String.valueOf(info.id)};
                    db.delete("shoppinglist", "_id=?", args);
                    queryData();
                    return true;
            }
            return super.onOptionsItemSelected(item);
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            // close cursor and db connection
            cursor.close();
            db.close();
        }
    }


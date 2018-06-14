package fi.jamk.shoppinglist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "product.db";
    private final String DATABASE_TABLE = "shoppinglist";
    private final String PRODUCT = "product";
    private final String COUNT = "count";
    private final String PRICE = "price";

    public DatabaseOpenHelper(Context context) {
        // Context, database name, optional cursor factory, database version
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create a new table
        db.execSQL("CREATE TABLE "+DATABASE_TABLE+" (_id INTEGER PRIMARY KEY AUTOINCREMENT, "+PRODUCT+" TEXT, "+COUNT+" REAL, "+PRICE+" REAL);");
        // create sample data
        ContentValues values = new ContentValues();
        values.put(PRODUCT, "MILK");
        values.put(COUNT, 1);
        values.put(PRICE, 10);
        // insert data to database, name of table, "Nullcolumnhack", values
        db.insert(DATABASE_TABLE, null, values);
        // a more data...
        values.put(PRODUCT, "CANDY");
        values.put(COUNT, 1);
        values.put(PRICE, 5);
        db.insert(DATABASE_TABLE, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+DATABASE_TABLE);
        onCreate(db);
    }
}

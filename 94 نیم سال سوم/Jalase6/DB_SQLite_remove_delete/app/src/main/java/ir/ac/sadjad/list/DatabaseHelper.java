package ir.ac.sadjad.list;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/***
 * Created by reza on 95/05/11.
 ***/
public class DatabaseHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        setForcedUpgrade();
    }
}

package ir.ac.sadjad.librarybooks.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.orhanobut.hawk.Hawk;
import com.orhanobut.hawk.HawkBuilder;
import com.orhanobut.hawk.LogLevel;

import java.util.ArrayList;
import java.util.List;

/***
 * Created by reza on 95/2/15.
 ***/
public class DataManager {

    public boolean needShowSplash(Context context) {
        Hawk.init(context)
                .setEncryptionMethod(HawkBuilder.EncryptionMethod.MEDIUM)
                .setPassword("23456890")
                .setStorage(HawkBuilder.newSharedPrefStorage(context))
                .setLogLevel(LogLevel.NONE)
                .build();

        boolean splash = Hawk.get("splash", true);
        return splash;
    }

    public void setSplashStatus(boolean status) {
        Hawk.put("splash", status);
    }

    public List<String> getBookList(Context context) {
        List<String> list = new ArrayList<>();

        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase database = databaseHelper.getReadableDatabase();

        Cursor cursor = database.rawQuery("SELECT book_name FROM books", null);

        /*SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        String[] sqlSelect = {"book_name"};
        String sqlTables = "books";
        queryBuilder.setTables(sqlTables);

        Cursor cursor = queryBuilder.query(database, sqlSelect, null, null, null, null, null);*/

        if (cursor != null && cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(cursor.getColumnIndex("book_name")));
            } while (cursor.moveToNext());

            cursor.close();
        }

//        list.add("کتاب ۱");
//        list.add("کتاب ۲");
//        list.add("کتاب ۳");
//        list.add("کتاب ۴");
//        list.add("کتاب ۵");
//        list.add("کتاب ۶");
//        list.add("کتاب ۷");
//        list.add("کتاب ۸");
//        list.add("کتاب ۹");
//        list.add("کتاب ۱۰");

        return list;
    }
}

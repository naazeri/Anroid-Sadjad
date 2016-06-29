package ir.ac.sadjad.librarybooks.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Message;

import com.orhanobut.hawk.Hawk;
import com.orhanobut.hawk.HawkBuilder;
import com.orhanobut.hawk.LogLevel;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import ir.ac.sadjad.librarybooks.MainActivity;
import ir.ac.sadjad.librarybooks.model.ModelBook;

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

    public List<ModelBook> getBookList(Context context) {
        List<ModelBook> list = new ArrayList<>();

        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase database = databaseHelper.getReadableDatabase();

//        Cursor cursor = database.rawQuery("SELECT book_name FROM books", null);

        String tableName = "books";
        String[] columns = {"book_name", "count"};
        Cursor cursor = database.query(tableName, columns, null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                // create model
                ModelBook book = new ModelBook();
                book.setBookName(cursor.getString(cursor.getColumnIndex("book_name")));
                book.setCount(cursor.getInt(cursor.getColumnIndex("count")));

                // add model to list
                list.add(book);
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

        database.close();
        return list;
    }

    public void saveBook(Context context, String bookName, Integer bookCount) {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase database = databaseHelper.getWritableDatabase();

        String tableName = "books";
        ContentValues values = new ContentValues();
        values.put("book_name", bookName);
        values.put("count", bookCount);
        database.insert(tableName, null, values);

        /*String query = "INSERT INTO books (book_name, count) VALUES (?, ?)";
        String[] args = {bookName, bookCount.toString()};
        database.execSQL(query, args);*/

        database.close();
    }
}

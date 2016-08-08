package ir.ac.sadjad.list;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;

public class DataManager {

    private final String BOOK_TABLE = "books";

    public List<Model> getListData(Context context) {
        List<Model> list = new LinkedList<>();

        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase database = databaseHelper.getReadableDatabase();

//        Cursor cursor = database.rawQuery("SELECT book_name FROM books", null);

        String[] columns = {};
        Cursor cursor = database.query(BOOK_TABLE, columns, null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                Model model = new Model();

                /** initialize model **/
                model.setId(cursor.getInt(cursor.getColumnIndex("id")));
                model.setBookName(cursor.getString(cursor.getColumnIndex("book_name")));
                model.setCount(cursor.getInt(cursor.getColumnIndex("count")));

                /** add data(model) to list**/
                list.add(model);
            } while (cursor.moveToNext());

            cursor.close();
        }

        database.close();
        return list;
    }

    public void saveInDB(Context context, Model model) {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase database = databaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("book_name", model.getBookName());
        database.insert(BOOK_TABLE, null, values);

        /*String[] args = {model.getBookName()};
        database.execSQL("INSERT INTO books (book_name) VALUES (?)", args);*/

        database.close();
    }

    public void updateDB(Context context, Model model) {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase database = databaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("book_name", model.getBookName());
        String where = "id=?";
        String[] whereArgs = {model.getId().toString()};
        database.update(BOOK_TABLE, values, where, whereArgs);

        /*String[] args = {model.getBookName(), model.getId().toString()};
        database.execSQL("UPDATE books SET book_name=? WHERE id=?", args);*/

        database.close();
    }

    public void removeFromDB(Context context, Model model) {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase database = databaseHelper.getReadableDatabase();

        String where = "id=?";
        String[] whereArgs = {model.getId().toString()};
        database.delete(BOOK_TABLE, where, whereArgs);

//        database.execSQL("DELETE FROM books WHERE id=" + model.getId().toString());

        database.close();
    }
}

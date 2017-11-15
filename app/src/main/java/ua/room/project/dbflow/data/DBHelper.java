package ua.room.project.dbflow.data;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static ua.room.project.dbflow.provider.MyContentProvider.DATA_BASE_NAME;
import static ua.room.project.dbflow.provider.MyContentProvider.DATA_BASE_NUMBER;
import static ua.room.project.dbflow.provider.MyContentProvider.DB_CREATE;

/**
 * Created by kunde on 15.11.2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, DATA_BASE_NAME, null, DATA_BASE_NUMBER);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

package ua.room.project.dbflow.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import ua.room.project.dbflow.data.DBHelper;

/**
 * Created by kunde on 15.11.2017.
 */

public class MyContentProvider extends ContentProvider {
    public static final String DATA_BASE_NAME = "AppDataBase";
    public static final int DATA_BASE_NUMBER = 1;
    public static final String TABLE_WORKER_NAME = "worker_table";

    public static final String AUTHORIRIES = "ua.room.project.dbflow";

    public static final String WORKER_ID = "worker_id";
    public static final String WORKER_NAME = "worker_name";
    public static final String WORKER_PHONE = "worker_phone";
    public static final String WORKER_BIRTHDAY = "worker_birthday";
    public static final String WORKER_COMPANY = "worker_company";

    public static final String WORKER_PATH = "workers";

    public static final Uri WORKER_CONTENT_URI = Uri.parse("content://"
            + AUTHORIRIES + "/" + WORKER_PATH);

    // набор строк
    static final String WORKER_CONTENT_TYPE = "vnd.android.cursor.dir/vnd."
            + AUTHORIRIES + "." + WORKER_PATH;

    // одна строка
    static final String WORKER_CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd."
            + AUTHORIRIES + "." + WORKER_PATH;

    public static final int URI_WORKERS = 1;
    public static final int URI_WORKERS_ID = 2;

    private static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORIRIES, WORKER_PATH, URI_WORKERS);
        uriMatcher.addURI(AUTHORIRIES, WORKER_PATH + "/#", URI_WORKERS_ID);
    }

    public static final String DB_CREATE = "create table " + TABLE_WORKER_NAME + "("
            + WORKER_ID + " integer primary key autoincrement, "
            + WORKER_NAME + " text, "
            + WORKER_PHONE + " text, "
            + WORKER_BIRTHDAY + " text, "
            + WORKER_COMPANY + " text"
            + ");";

    private DBHelper mDBhelper;
    private SQLiteDatabase database;


    @Override
    public boolean onCreate() {
        mDBhelper = new DBHelper(getContext());
        return true;
    }


    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s,
                        @Nullable String[] strings1, @Nullable String s1) {
        switch (uriMatcher.match(uri)) {
            case URI_WORKERS:
                if (TextUtils.isEmpty(s1)) {
                    s1 = WORKER_NAME + " ASC";
                }
                break;
            case URI_WORKERS_ID:
                String id = uri.getLastPathSegment();
                if (TextUtils.isEmpty(s)) {
                    s = WORKER_ID + " = " + id;
                } else {
                    s = s + " AND " + WORKER_ID + " = " + id;
                }
                break;
            default:
                throw new IllegalArgumentException("Wrong URI: " + uri);
        }
        database = mDBhelper.getWritableDatabase();

        Cursor cursor = database.query(TABLE_WORKER_NAME, strings, s, strings1, null, null, s1);
        cursor.setNotificationUri(getContext().getContentResolver(), WORKER_CONTENT_URI);
        return null;
    }


    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        if (uriMatcher.match(uri) != URI_WORKERS) {
            throw new IllegalArgumentException("Wrong URI: " + uri);
        }
        long rowId = database.insert(TABLE_WORKER_NAME, null, contentValues);

        Uri resultUri = ContentUris.withAppendedId(WORKER_CONTENT_URI, rowId);
        getContext().getContentResolver().notifyChange(resultUri, null);
        return resultUri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        switch (uriMatcher.match(uri)) {
            case URI_WORKERS:
                break;
            case URI_WORKERS_ID:
                String id = uri.getLastPathSegment();
                if (TextUtils.isEmpty(s)) {
                    s = WORKER_ID + " = " + id;
                } else {
                    s = s + " AND " + WORKER_ID + " = " + id;
                }
                break;
            default:
                throw new IllegalArgumentException("Wrong URI: " + uri);
        }
        database = mDBhelper.getWritableDatabase();
        int count = database.delete(TABLE_WORKER_NAME, s, strings);
        Uri resultUri = ContentUris.withAppendedId(WORKER_CONTENT_URI, count);
        getContext().getContentResolver().notifyChange(resultUri, null);
        return count;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        switch (uriMatcher.match(uri)) {
            case URI_WORKERS:
                break;
            case URI_WORKERS_ID:
                String id = uri.getLastPathSegment();
                if (TextUtils.isEmpty(s)) {
                    s = WORKER_ID + " = " + id;
                } else {
                    s = s + " AND " + WORKER_ID + " = " + id;
                }
                break;
            default:
                throw new IllegalArgumentException("Wrong URI: " + uri);
        }
        database = mDBhelper.getWritableDatabase();
        int count = database.update(TABLE_WORKER_NAME, contentValues, s, strings);
        Uri resultUri = ContentUris.withAppendedId(WORKER_CONTENT_URI, count);
        getContext().getContentResolver().notifyChange(resultUri, null);
        return count;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (uriMatcher.match(uri)) {
            case URI_WORKERS:
                return WORKER_CONTENT_TYPE;
            case URI_WORKERS_ID:
                return WORKER_CONTENT_ITEM_TYPE;
        }
        return null;
    }
}

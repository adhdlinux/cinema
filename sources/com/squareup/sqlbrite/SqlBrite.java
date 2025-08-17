package com.squareup.sqlbrite;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public final class SqlBrite {
    private final Logger logger;

    public interface Logger {
        void log(String str);
    }

    public interface Query {
        Cursor run();
    }

    private SqlBrite(Logger logger2) {
        this.logger = logger2;
    }

    public static SqlBrite create() {
        return create(new Logger() {
            public void log(String str) {
                Log.d("SqlBrite", str);
            }
        });
    }

    public BriteContentResolver wrapContentProvider(ContentResolver contentResolver) {
        return new BriteContentResolver(contentResolver, this.logger);
    }

    public BriteDatabase wrapDatabaseHelper(SQLiteOpenHelper sQLiteOpenHelper) {
        return new BriteDatabase(sQLiteOpenHelper, this.logger);
    }

    public static SqlBrite create(Logger logger2) {
        return new SqlBrite(logger2);
    }
}

package androidx.media3.database;

import android.database.sqlite.SQLiteDatabase;

public interface DatabaseProvider {
    SQLiteDatabase getReadableDatabase();

    SQLiteDatabase getWritableDatabase();
}

package androidx.media3.datasource.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.media3.common.util.Assertions;
import androidx.media3.database.DatabaseIOException;
import androidx.media3.database.DatabaseProvider;
import androidx.media3.database.VersionTable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

final class CacheFileMetadataIndex {

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f4972c = {"name", "length", "last_touch_timestamp"};

    /* renamed from: a  reason: collision with root package name */
    private final DatabaseProvider f4973a;

    /* renamed from: b  reason: collision with root package name */
    private String f4974b;

    public CacheFileMetadataIndex(DatabaseProvider databaseProvider) {
        this.f4973a = databaseProvider;
    }

    private static void a(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
    }

    private Cursor c() {
        Assertions.f(this.f4974b);
        return this.f4973a.getReadableDatabase().query(this.f4974b, f4972c, (String) null, (String[]) null, (String) null, (String) null, (String) null);
    }

    private static String d(String str) {
        return "ExoPlayerCacheFileMetadata" + str;
    }

    public Map<String, CacheFileMetadata> b() throws DatabaseIOException {
        Cursor c2;
        try {
            c2 = c();
            HashMap hashMap = new HashMap(c2.getCount());
            while (c2.moveToNext()) {
                hashMap.put((String) Assertions.f(c2.getString(0)), new CacheFileMetadata(c2.getLong(1), c2.getLong(2)));
            }
            c2.close();
            return hashMap;
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public void e(long j2) throws DatabaseIOException {
        SQLiteDatabase writableDatabase;
        try {
            String hexString = Long.toHexString(j2);
            this.f4974b = d(hexString);
            if (VersionTable.b(this.f4973a.getReadableDatabase(), 2, hexString) != 1) {
                writableDatabase = this.f4973a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                VersionTable.d(writableDatabase, 2, hexString, 1);
                a(writableDatabase, this.f4974b);
                writableDatabase.execSQL("CREATE TABLE " + this.f4974b + " " + "(name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)");
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            }
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
    }

    public void f(String str) throws DatabaseIOException {
        Assertions.f(this.f4974b);
        try {
            this.f4973a.getWritableDatabase().delete(this.f4974b, "name = ?", new String[]{str});
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    public void g(Set<String> set) throws DatabaseIOException {
        SQLiteDatabase writableDatabase;
        Assertions.f(this.f4974b);
        try {
            writableDatabase = this.f4973a.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            for (String str : set) {
                writableDatabase.delete(this.f4974b, "name = ?", new String[]{str});
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
    }

    public void h(String str, long j2, long j3) throws DatabaseIOException {
        Assertions.f(this.f4974b);
        try {
            SQLiteDatabase writableDatabase = this.f4973a.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", str);
            contentValues.put("length", Long.valueOf(j2));
            contentValues.put("last_touch_timestamp", Long.valueOf(j3));
            writableDatabase.replaceOrThrow(this.f4974b, (String) null, contentValues);
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }
}

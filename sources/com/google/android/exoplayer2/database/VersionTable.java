package com.google.android.exoplayer2.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.util.Util;
import com.unity3d.ads.metadata.MediationMetaData;

public final class VersionTable {
    static {
        ExoPlayerLibraryInfo.a("goog.exo.database");
    }

    private VersionTable() {
    }

    private static String[] a(int i2, String str) {
        return new String[]{Integer.toString(i2), str};
    }

    public static int b(SQLiteDatabase sQLiteDatabase, int i2, String str) throws DatabaseIOException {
        Cursor query;
        try {
            if (!Util.b1(sQLiteDatabase, "ExoPlayerVersions")) {
                return -1;
            }
            query = sQLiteDatabase.query("ExoPlayerVersions", new String[]{MediationMetaData.KEY_VERSION}, "feature = ? AND instance_uid = ?", a(i2, str), (String) null, (String) null, (String) null);
            if (query.getCount() == 0) {
                query.close();
                return -1;
            }
            query.moveToNext();
            int i3 = query.getInt(0);
            query.close();
            return i3;
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static void c(SQLiteDatabase sQLiteDatabase, int i2, String str) throws DatabaseIOException {
        try {
            if (Util.b1(sQLiteDatabase, "ExoPlayerVersions")) {
                sQLiteDatabase.delete("ExoPlayerVersions", "feature = ? AND instance_uid = ?", a(i2, str));
            }
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    public static void d(SQLiteDatabase sQLiteDatabase, int i2, String str, int i3) throws DatabaseIOException {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ExoPlayerVersions (feature INTEGER NOT NULL,instance_uid TEXT NOT NULL,version INTEGER NOT NULL,PRIMARY KEY (feature, instance_uid))");
            ContentValues contentValues = new ContentValues();
            contentValues.put("feature", Integer.valueOf(i2));
            contentValues.put("instance_uid", str);
            contentValues.put(MediationMetaData.KEY_VERSION, Integer.valueOf(i3));
            sQLiteDatabase.replaceOrThrow("ExoPlayerVersions", (String) null, contentValues);
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }
}

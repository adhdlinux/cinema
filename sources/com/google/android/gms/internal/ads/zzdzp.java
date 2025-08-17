package com.google.android.gms.internal.ads;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class zzdzp extends SQLiteOpenHelper {
    public zzdzp(Context context) {
        super(context, "OfflineUpload.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE offline_signal_contents (timestamp INTEGER PRIMARY_KEY, serialized_proto_data BLOB)");
        sQLiteDatabase.execSQL("CREATE TABLE offline_signal_statistics (statistic_name TEXT PRIMARY_KEY, value INTEGER)");
        zzeai.zze(sQLiteDatabase);
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        onUpgrade(sQLiteDatabase, i2, i3);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_signal_contents");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_signal_statistics");
    }
}

package com.google.android.exoplayer2.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class DefaultDatabaseProvider implements DatabaseProvider {

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteOpenHelper f23934a;

    public DefaultDatabaseProvider(SQLiteOpenHelper sQLiteOpenHelper) {
        this.f23934a = sQLiteOpenHelper;
    }

    public SQLiteDatabase getReadableDatabase() {
        return this.f23934a.getReadableDatabase();
    }

    public SQLiteDatabase getWritableDatabase() {
        return this.f23934a.getWritableDatabase();
    }
}

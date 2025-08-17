package com.startapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public abstract class pa extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public volatile SQLiteDatabase f35614a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f35615b = new Object();

    public pa(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i2);
    }

    public SQLiteDatabase a() {
        SQLiteDatabase sQLiteDatabase = this.f35614a;
        if (sQLiteDatabase == null) {
            synchronized (this.f35615b) {
                sQLiteDatabase = this.f35614a;
                if (sQLiteDatabase == null) {
                    sQLiteDatabase = getWritableDatabase();
                    this.f35614a = sQLiteDatabase;
                }
            }
        }
        return sQLiteDatabase;
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}

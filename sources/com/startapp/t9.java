package com.startapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

public class t9 extends pa {

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f36579c = {"id"};

    public t9(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public void a(String str, String str2, long j2, long j3) {
        String str3 = str;
        String str4 = str2;
        SQLiteDatabase a2 = a();
        a2.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            long a3 = a(a2, "requests", str);
            if (a3 < 0) {
                contentValues.clear();
                contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, str);
                a3 = a2.insert("requests", (String) null, contentValues);
            }
            long a4 = a(a2, "statuses", str4);
            if (a4 < 0) {
                contentValues.clear();
                contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, str4);
                a4 = a2.insert("statuses", (String) null, contentValues);
            }
            contentValues.clear();
            contentValues.put("requestId", Long.valueOf(a3));
            contentValues.put("statusId", Long.valueOf(a4));
            contentValues.put("timeMillis", Long.valueOf(j2));
            contentValues.put("durationNanos", Long.valueOf(j3));
            a2.insert("traces", (String) null, contentValues);
            a2.setTransactionSuccessful();
        } finally {
            a2.endTransaction();
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS requests (id INTEGER PRIMARY KEY ASC AUTOINCREMENT NOT NULL,value TEXT NOT NULL UNIQUE,CHECK (value = TRIM(value) AND LENGTH(value) > 0));");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS statuses (id INTEGER PRIMARY KEY ASC AUTOINCREMENT NOT NULL,value TEXT NOT NULL UNIQUE,CHECK (value = TRIM(value) AND LENGTH(value) > 0));");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS traces (requestId INTEGER NOT NULL,statusId INTEGER NOT NULL,timeMillis INTEGER NOT NULL,durationNanos INTEGER NOT NULL,FOREIGN KEY (requestId)REFERENCES requests (requestId)ON UPDATE CASCADE ON DELETE CASCADE,FOREIGN KEY (statusId)REFERENCES statuses (statusId)ON UPDATE CASCADE ON DELETE CASCADE,CHECK (timeMillis > 0),CHECK (durationNanos > 0));");
    }

    public static long a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        Cursor query = sQLiteDatabase.query(str, f36579c, "value=?", new String[]{str2}, (String) null, (String) null, (String) null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    return query.getLong(0);
                }
            } finally {
                query.close();
            }
        }
        if (query == null) {
            return -1;
        }
        query.close();
        return -1;
    }
}

package com.adcolony.sdk;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.adcolony.sdk.e0;

class p {
    static void a(int i2, long j2, String str, String str2, SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            if (str == null) {
                str = "rowid";
                j2 = -1;
            }
            if (i2 >= 0) {
                Cursor rawQuery = sQLiteDatabase.rawQuery("select " + str + " from " + str2 + " order by " + str + " desc limit 1 offset " + i2, (String[]) null);
                if (rawQuery.moveToFirst()) {
                    j2 = Math.max(j2, rawQuery.getLong(0));
                }
                rawQuery.close();
            }
            if (j2 >= 0) {
                sQLiteDatabase.execSQL("delete from " + str2 + " where " + str + " <= " + j2);
            }
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e2) {
            try {
                new e0.a().c("Exception on deleting excessive rows:").c(e2.toString()).d(e0.f13112g);
            } catch (Throwable th) {
                new e0.a().c("Error on deleting excessive rows:").c(th.toString()).d(e0.f13114i);
                return;
            }
        }
        sQLiteDatabase.endTransaction();
    }

    static void b(String str, ContentValues contentValues, SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.insertOrThrow(str, (String) null, contentValues);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e2) {
            try {
                e0.a aVar = new e0.a();
                e0.a a2 = aVar.c("Exception on insert to " + str + ", db version:").a(sQLiteDatabase.getVersion());
                a2.c(". Values: " + contentValues.toString() + " caused: ").c(e2.toString()).d(e0.f13112g);
            } catch (Throwable th) {
                e0.a aVar2 = new e0.a();
                e0.a a3 = aVar2.c("Error on insert to " + str + ", db version:").a(sQLiteDatabase.getVersion());
                a3.c(". Values: " + contentValues.toString() + " caused: ").c(th.toString()).d(e0.f13114i);
                return;
            }
        }
        sQLiteDatabase.endTransaction();
    }
}

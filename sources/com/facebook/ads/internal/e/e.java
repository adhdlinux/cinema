package com.facebook.ads.internal.e;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class e extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private final d f20129a;

    public e(Context context, d dVar) {
        super(context, "ads.db", (SQLiteDatabase.CursorFactory) null, 4);
        if (dVar != null) {
            this.f20129a = dVar;
            return;
        }
        throw new IllegalArgumentException("AdDatabaseHelper can not be null");
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (g a2 : this.f20129a.c()) {
            a2.a(sQLiteDatabase);
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        for (g gVar : this.f20129a.c()) {
            gVar.b(sQLiteDatabase);
            gVar.a(sQLiteDatabase);
        }
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        if (!sQLiteDatabase.isReadOnly()) {
            sQLiteDatabase.execSQL("PRAGMA foreign_keys = ON;");
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i2 == 2 && i3 >= 3) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS crashes");
        }
        if (i2 <= 3 && i3 >= 4) {
            b bVar = c.f20099i;
            sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN " + bVar.f20089b + " " + bVar.f20090c + " DEFAULT 0");
        }
    }
}

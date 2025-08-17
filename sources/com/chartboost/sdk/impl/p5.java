package com.chartboost.sdk.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class p5 extends SQLiteOpenHelper {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p5(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? "chartboost_exoplayer.db" : str, (i3 & 4) != 0 ? null : cursorFactory, (i3 & 8) != 0 ? 1 : i2);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p5(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, str, cursorFactory, i2);
        Intrinsics.f(context, "context");
        Intrinsics.f(str, "name");
    }
}

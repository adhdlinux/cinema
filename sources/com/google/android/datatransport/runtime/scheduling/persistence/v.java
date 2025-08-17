package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class v implements SQLiteEventStore.Producer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteDatabase f22770a;

    public /* synthetic */ v(SQLiteDatabase sQLiteDatabase) {
        this.f22770a = sQLiteDatabase;
    }

    public final Object a() {
        return this.f22770a.beginTransaction();
    }
}

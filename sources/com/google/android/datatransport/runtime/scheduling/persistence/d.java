package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class d implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f22748a;

    public /* synthetic */ d(SQLiteEventStore sQLiteEventStore) {
        this.f22748a = sQLiteEventStore;
    }

    public final Object apply(Object obj) {
        return this.f22748a.m1((SQLiteDatabase) obj);
    }
}

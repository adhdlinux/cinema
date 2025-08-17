package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class e implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f22749a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f22750b;

    public /* synthetic */ e(SQLiteEventStore sQLiteEventStore, TransportContext transportContext) {
        this.f22749a = sQLiteEventStore;
        this.f22750b = transportContext;
    }

    public final Object apply(Object obj) {
        return this.f22749a.a1(this.f22750b, (SQLiteDatabase) obj);
    }
}

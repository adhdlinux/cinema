package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class a0 implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f22741a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f22742b;

    public /* synthetic */ a0(SQLiteEventStore sQLiteEventStore, TransportContext transportContext) {
        this.f22741a = sQLiteEventStore;
        this.f22742b = transportContext;
    }

    public final Object apply(Object obj) {
        return this.f22741a.X0(this.f22742b, (SQLiteDatabase) obj);
    }
}

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class c implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f22746a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f22747b;

    public /* synthetic */ c(long j2, TransportContext transportContext) {
        this.f22746a = j2;
        this.f22747b = transportContext;
    }

    public final Object apply(Object obj) {
        return SQLiteEventStore.l1(this.f22746a, this.f22747b, (SQLiteDatabase) obj);
    }
}

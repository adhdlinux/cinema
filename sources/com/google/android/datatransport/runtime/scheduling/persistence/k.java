package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.List;

public final /* synthetic */ class k implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f22760a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f22761b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TransportContext f22762c;

    public /* synthetic */ k(SQLiteEventStore sQLiteEventStore, List list, TransportContext transportContext) {
        this.f22760a = sQLiteEventStore;
        this.f22761b = list;
        this.f22762c = transportContext;
    }

    public final Object apply(Object obj) {
        return this.f22760a.d1(this.f22761b, this.f22762c, (Cursor) obj);
    }
}

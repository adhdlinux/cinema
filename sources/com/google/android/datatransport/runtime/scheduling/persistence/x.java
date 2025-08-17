package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class x implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f22771a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EventInternal f22772b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TransportContext f22773c;

    public /* synthetic */ x(SQLiteEventStore sQLiteEventStore, EventInternal eventInternal, TransportContext transportContext) {
        this.f22771a = sQLiteEventStore;
        this.f22772b = eventInternal;
        this.f22773c = transportContext;
    }

    public final Object apply(Object obj) {
        return this.f22771a.f1(this.f22772b, this.f22773c, (SQLiteDatabase) obj);
    }
}

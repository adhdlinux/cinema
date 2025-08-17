package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.Map;

public final /* synthetic */ class q implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f22765a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f22766b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ClientMetrics.Builder f22767c;

    public /* synthetic */ q(SQLiteEventStore sQLiteEventStore, Map map, ClientMetrics.Builder builder) {
        this.f22765a = sQLiteEventStore;
        this.f22766b = map;
        this.f22767c = builder;
    }

    public final Object apply(Object obj) {
        return this.f22765a.b1(this.f22766b, this.f22767c, (Cursor) obj);
    }
}

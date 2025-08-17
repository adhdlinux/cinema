package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class y implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f22774a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f22775b;

    public /* synthetic */ y(SQLiteEventStore sQLiteEventStore, long j2) {
        this.f22774a = sQLiteEventStore;
        this.f22775b = j2;
    }

    public final Object apply(Object obj) {
        return this.f22774a.P0(this.f22775b, (SQLiteDatabase) obj);
    }
}

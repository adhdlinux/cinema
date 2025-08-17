package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class n implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f22764a;

    public /* synthetic */ n(SQLiteEventStore sQLiteEventStore) {
        this.f22764a = sQLiteEventStore;
    }

    public final Object apply(Object obj) {
        return this.f22764a.h1((Cursor) obj);
    }
}

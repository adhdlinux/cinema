package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class l implements SQLiteEventStore.Producer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SchemaManager f22763a;

    public /* synthetic */ l(SchemaManager schemaManager) {
        this.f22763a = schemaManager;
    }

    public final Object a() {
        return this.f22763a.getWritableDatabase();
    }
}

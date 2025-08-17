package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.Map;

public final /* synthetic */ class j implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f22756a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22757b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f22758c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ClientMetrics.Builder f22759d;

    public /* synthetic */ j(SQLiteEventStore sQLiteEventStore, String str, Map map, ClientMetrics.Builder builder) {
        this.f22756a = sQLiteEventStore;
        this.f22757b = str;
        this.f22758c = map;
        this.f22759d = builder;
    }

    public final Object apply(Object obj) {
        return this.f22756a.c1(this.f22757b, this.f22758c, this.f22759d, (SQLiteDatabase) obj);
    }
}

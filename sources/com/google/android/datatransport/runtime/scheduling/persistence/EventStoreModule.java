package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import javax.inject.Named;

public abstract class EventStoreModule {
    @Named("SQLITE_DB_NAME")
    static String a() {
        return "com.google.android.datatransport.events";
    }

    @Named("PACKAGE_NAME")
    static String b(Context context) {
        return context.getPackageName();
    }

    @Named("SCHEMA_VERSION")
    static int c() {
        return SchemaManager.f22729e;
    }

    static EventStoreConfig d() {
        return EventStoreConfig.f22710a;
    }
}

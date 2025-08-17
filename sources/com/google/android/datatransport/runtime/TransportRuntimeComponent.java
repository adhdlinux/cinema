package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import java.io.Closeable;
import java.io.IOException;
import javax.inject.Singleton;

@Singleton
abstract class TransportRuntimeComponent implements Closeable {

    interface Builder {
        Builder a(Context context);

        TransportRuntimeComponent build();
    }

    TransportRuntimeComponent() {
    }

    /* access modifiers changed from: package-private */
    public abstract EventStore a();

    public void close() throws IOException {
        a().close();
    }

    /* access modifiers changed from: package-private */
    public abstract TransportRuntime f();
}

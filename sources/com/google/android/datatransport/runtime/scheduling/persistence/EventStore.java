package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import java.io.Closeable;

public interface EventStore extends Closeable {
    long J(TransportContext transportContext);

    boolean K(TransportContext transportContext);

    void M(Iterable<PersistedEvent> iterable);

    Iterable<PersistedEvent> T(TransportContext transportContext);

    void b(Iterable<PersistedEvent> iterable);

    int cleanUp();

    PersistedEvent g0(TransportContext transportContext, EventInternal eventInternal);

    void m(TransportContext transportContext, long j2);

    Iterable<TransportContext> o();
}

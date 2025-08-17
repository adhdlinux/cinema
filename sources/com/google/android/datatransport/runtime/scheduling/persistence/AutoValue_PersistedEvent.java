package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;

final class AutoValue_PersistedEvent extends PersistedEvent {

    /* renamed from: a  reason: collision with root package name */
    private final long f22707a;

    /* renamed from: b  reason: collision with root package name */
    private final TransportContext f22708b;

    /* renamed from: c  reason: collision with root package name */
    private final EventInternal f22709c;

    AutoValue_PersistedEvent(long j2, TransportContext transportContext, EventInternal eventInternal) {
        this.f22707a = j2;
        if (transportContext != null) {
            this.f22708b = transportContext;
            if (eventInternal != null) {
                this.f22709c = eventInternal;
                return;
            }
            throw new NullPointerException("Null event");
        }
        throw new NullPointerException("Null transportContext");
    }

    public EventInternal b() {
        return this.f22709c;
    }

    public long c() {
        return this.f22707a;
    }

    public TransportContext d() {
        return this.f22708b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersistedEvent)) {
            return false;
        }
        PersistedEvent persistedEvent = (PersistedEvent) obj;
        if (this.f22707a != persistedEvent.c() || !this.f22708b.equals(persistedEvent.d()) || !this.f22709c.equals(persistedEvent.b())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j2 = this.f22707a;
        return this.f22709c.hashCode() ^ ((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ this.f22708b.hashCode()) * 1000003);
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f22707a + ", transportContext=" + this.f22708b + ", event=" + this.f22709c + "}";
    }
}

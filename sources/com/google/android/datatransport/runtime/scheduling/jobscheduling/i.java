package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class i implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f22683a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Iterable f22684b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TransportContext f22685c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f22686d;

    public /* synthetic */ i(Uploader uploader, Iterable iterable, TransportContext transportContext, long j2) {
        this.f22683a = uploader;
        this.f22684b = iterable;
        this.f22685c = transportContext;
        this.f22686d = j2;
    }

    public final Object execute() {
        return this.f22683a.n(this.f22684b, this.f22685c, this.f22686d);
    }
}

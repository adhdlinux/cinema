package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class f implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f22676a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f22677b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f22678c;

    public /* synthetic */ f(Uploader uploader, TransportContext transportContext, int i2) {
        this.f22676a = uploader;
        this.f22677b = transportContext;
        this.f22678c = i2;
    }

    public final Object execute() {
        return this.f22676a.s(this.f22677b, this.f22678c);
    }
}

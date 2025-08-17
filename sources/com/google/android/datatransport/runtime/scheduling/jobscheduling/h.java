package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class h implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f22681a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f22682b;

    public /* synthetic */ h(Uploader uploader, TransportContext transportContext) {
        this.f22681a = uploader;
        this.f22682b = transportContext;
    }

    public final Object execute() {
        return this.f22681a.m(this.f22682b);
    }
}

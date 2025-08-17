package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class m implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f22692a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f22693b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f22694c;

    public /* synthetic */ m(Uploader uploader, TransportContext transportContext, long j2) {
        this.f22692a = uploader;
        this.f22693b = transportContext;
        this.f22694c = j2;
    }

    public final Object execute() {
        return this.f22692a.r(this.f22693b, this.f22694c);
    }
}

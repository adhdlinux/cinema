package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class g implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f22679a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f22680b;

    public /* synthetic */ g(Uploader uploader, TransportContext transportContext) {
        this.f22679a = uploader;
        this.f22680b = transportContext;
    }

    public final Object execute() {
        return this.f22679a.l(this.f22680b);
    }
}

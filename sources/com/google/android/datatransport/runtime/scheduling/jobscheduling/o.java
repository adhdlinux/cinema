package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class o implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkInitializer f22696a;

    public /* synthetic */ o(WorkInitializer workInitializer) {
        this.f22696a = workInitializer;
    }

    public final Object execute() {
        return this.f22696a.d();
    }
}

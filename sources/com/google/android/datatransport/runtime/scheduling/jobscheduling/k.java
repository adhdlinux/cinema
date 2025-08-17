package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class k implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f22689a;

    public /* synthetic */ k(Uploader uploader) {
        this.f22689a = uploader;
    }

    public final Object execute() {
        return this.f22689a.p();
    }
}

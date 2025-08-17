package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class j implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f22687a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Iterable f22688b;

    public /* synthetic */ j(Uploader uploader, Iterable iterable) {
        this.f22687a = uploader;
        this.f22688b = iterable;
    }

    public final Object execute() {
        return this.f22687a.o(this.f22688b);
    }
}

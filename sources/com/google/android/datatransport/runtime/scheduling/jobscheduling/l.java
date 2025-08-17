package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.Map;

public final /* synthetic */ class l implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f22690a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f22691b;

    public /* synthetic */ l(Uploader uploader, Map map) {
        this.f22690a = uploader;
        this.f22691b = map;
    }

    public final Object execute() {
        return this.f22690a.q(this.f22691b);
    }
}

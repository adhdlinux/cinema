package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class d implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClientHealthMetricsStore f22674a;

    public /* synthetic */ d(ClientHealthMetricsStore clientHealthMetricsStore) {
        this.f22674a = clientHealthMetricsStore;
    }

    public final Object execute() {
        return this.f22674a.i();
    }
}

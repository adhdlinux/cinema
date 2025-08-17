package g0;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class b implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultScheduler f29069a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f29070b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ EventInternal f29071c;

    public /* synthetic */ b(DefaultScheduler defaultScheduler, TransportContext transportContext, EventInternal eventInternal) {
        this.f29069a = defaultScheduler;
        this.f29070b = transportContext;
        this.f29071c = eventInternal;
    }

    public final Object execute() {
        return this.f29069a.d(this.f29070b, this.f29071c);
    }
}
